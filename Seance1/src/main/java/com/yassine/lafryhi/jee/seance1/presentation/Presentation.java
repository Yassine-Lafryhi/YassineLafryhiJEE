package com.yassine.lafryhi.jee.seance1.presentation;

import com.yassine.lafryhi.jee.seance1.dao.DaoImpl;
import com.yassine.lafryhi.jee.seance1.metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        MetierImpl metier = new MetierImpl();
        DaoImpl dao = new DaoImpl();
        metier.setDao(dao);
        System.out.println(metier.calculer());
    }
}
