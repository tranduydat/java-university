/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-06-30    1.0        DatDuyTran       Release 1.0<br>
 */
package controller;

import dao.StatsDAO;
import dao.impl.StatsDAOImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Process:<br>
 * 1. Add a new view if an user is new to website<br>
 * 2. Get page view
 *
 * @author DatDuyTran
 */
public class SessionListener implements HttpSessionListener {

    /**
     * Update and Get count number of view page from table NumberOfViews in
     * database when begin access to web site
     *
     * @param se it is a <code>javax.servlet.http.HttpSessionEvent</code>
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        StatsDAO statsDAO = new StatsDAOImpl();
        try {
            if (se.getSession().isNew()) {
                statsDAO.addView();
            }
            String strNumberOfViews = String.format("%06d", statsDAO.getNumberOfViews());
            se.getSession().setAttribute("strNumberOfViews", strNumberOfViews);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SessionListener.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
