package com.yassine.lafryhi.jee.seance2.metier;

import com.yassine.lafryhi.jee.seance2.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    @Autowired
    @Qualifier("dao")
    private IDao dao;

    @Override
    public double calculer() {
        double temperature = dao.getData();
        return temperature * 540 / Math.cos(temperature * Math.PI);
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}

