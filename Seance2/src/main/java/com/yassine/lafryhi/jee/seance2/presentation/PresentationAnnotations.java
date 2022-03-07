package com.yassine.lafryhi.jee.seance2.presentation;

import com.yassine.lafryhi.jee.seance2.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresentationAnnotations {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.yassine.lafryhi.jee.seance2.dao",
                "com.yassine.lafryhi.jee.seance2.metier");

        IMetier metier = ctx.getBean(IMetier.class);

        System.out.println("Resultat = " + metier.calculer());

    }
}
