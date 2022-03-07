package com.yassine.lafryhi.jee.seance2.presentation;

import com.yassine.lafryhi.jee.seance2.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresentationXML {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");

        IMetier metier = (IMetier) context.getBean("metier");

        System.out.println("Resultat = " + metier.calculer());

    }
}

