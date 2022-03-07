package com.yassine.lafryhi.jee.seance1.dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Version BDD");
        return Math.random() * 40;
    }
}
