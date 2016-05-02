/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import com.eticaret.onlinecv.dao.BolumDao;
import com.eticaret.onlinecv.entity.Bolum;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import com.eticaret.onlinecv.entity.Bolum;

/**
 *
 * @author ali
 */
public class BolumDaoImpl implements BolumDao, Serializable {

    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public List<Bolum> getirBolumList() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        List<Bolum> list = session.createCriteria(Bolum.class)
                .list();
        tx.commit();
        session.close();

        return list;
    }

    @Override
    public Bolum getirBolum(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Bolum uni = (Bolum) session.get(Bolum.class, id);

        session.close();
        return uni;
    }

}
