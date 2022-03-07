package com.yassine.lafryhi.jee.seance1.presentation;

import com.yassine.lafryhi.jee.seance1.dao.IDao;
import com.yassine.lafryhi.jee.seance1.metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.newInstance();

        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();

        Method method = cMetier.getMethod("setDao", IDao.class);
        method.invoke(metier, dao);
        System.out.println("Resultat = " + metier.calculer());
    }
}
