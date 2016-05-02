/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import com.eticaret.onlinecv.dao.UniversiteDao;
import com.eticaret.onlinecv.entity.Universite;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ali
 */
public class UniversiteDaoImpl implements UniversiteDao, Serializable {

    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

     @Override
    public Universite getirUniversite(Integer id) {
         session = HibernateUtil.getSessionFactory().openSession();
         Universite uni = (Universite) session.get(Universite.class, id);

         session.close();
         return uni;

   }
    @Override
    public List<Universite> getirUniversiteList() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        List<Universite> list = session.createCriteria(Universite.class)
                .list();
        tx.commit();
        session.close();

        return list;
    }

}
