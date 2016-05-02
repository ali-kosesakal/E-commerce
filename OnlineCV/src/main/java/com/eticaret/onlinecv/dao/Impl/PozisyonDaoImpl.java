/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import com.eticaret.onlinecv.dao.PozisyonDao;
import com.eticaret.onlinecv.entity.Pozisyon;
import com.eticaret.onlinecv.entity.Proje;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ali
 */
public class PozisyonDaoImpl implements PozisyonDao,Serializable{
SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    @Override
    public List<Pozisyon> getirPozisyon() {
         session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        List<Pozisyon> list = session.createCriteria(Pozisyon.class)
                .list();
        tx.commit();
        session.close();

        return list;
    }
    
}
