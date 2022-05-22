package com.yassine.lafryhi.jee.seance10.controllers;

import com.yassine.lafryhi.jee.seance10.dtos.ProductDTO;
import com.yassine.lafryhi.jee.seance10.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> productList() {
        return productService.listProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable(name = "id") String id) {
        return productService.getProduct(id);
    }

    @PostMapping("/products")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @PutMapping("/products/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable String id) {
        productDTO.setId(id);
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
