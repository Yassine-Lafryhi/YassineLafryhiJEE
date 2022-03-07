package com.yassine.lafryhi.jee.seance2.dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        return Math.random() * 40;
    }
}
