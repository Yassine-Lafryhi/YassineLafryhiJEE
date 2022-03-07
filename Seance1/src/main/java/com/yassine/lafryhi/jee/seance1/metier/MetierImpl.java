package com.yassine.lafryhi.jee.seance1.metier;

import com.yassine.lafryhi.jee.seance1.dao.IDao;

public class MetierImpl implements IMetier {
    // Couplage faible
    private IDao dao;

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calculer() {
        double temperature = dao.getData();
        return temperature * 540 / Math.cos(temperature * Math.PI);
    }

}
