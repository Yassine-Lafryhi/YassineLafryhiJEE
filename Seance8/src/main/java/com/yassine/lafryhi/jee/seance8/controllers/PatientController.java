package com.yassine.lafryhi.jee.seance8.controllers;

import com.yassine.lafryhi.jee.seance8.entities.Patient;
import com.yassine.lafryhi.jee.seance8.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path = "/patients-list")
    public String patients(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "10") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) throws Exception {
        if (page < 0) {
            return "redirect:/patients-list?page=" + 0 + "&keyword=" + keyword;
        }
        Page<Patient> pagePatients = patientRepository.findByNameContains(keyword, PageRequest.of(page, size));
        if (page > pagePatients.getTotalPages()) {
            return "redirect:/patients-list?page=" + (pagePatients.getTotalPages() - 1) + "&keyword=" + keyword;
        }
        model.addAttribute("patients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients-list";
    }

    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page) {
        patientRepository.deleteById(id);
        return "redirect:/patients-list?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> listPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/add-patient")
    public String formPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @GetMapping("/edit-patient")
    public String editPatient(Model model, Long id, String keyword, int page) {
        Patient patient = patientRepository.findById(id).orElse(null);
        System.out.println(patient.getName());
        if (patient == null) throw new RuntimeException("NULL");
        model.addAttribute("patient", patient);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "edit-patient";
    }

    @PostMapping("/save-add")
    public String saveAdd(Model model, @Valid Patient patient, BindingResult bindingResult,
                          @RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "") String keyword) {
        if (bindingResult.hasErrors()) return "add-patient";
        patientRepository.save(patient);
        return "redirect:/patients-list?page" + page + "&keyword" + keyword;
    }

    @PostMapping("/save-edit")
    public String saveEdit(Model model, @Valid Patient patient, BindingResult bindingResult,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String keyword) {
        if (bindingResult.hasErrors()) return "edit-patient";
        patientRepository.save(patient);
        return "redirect:/patients-list?page" + page + "&keyword" + keyword;
    }

}
