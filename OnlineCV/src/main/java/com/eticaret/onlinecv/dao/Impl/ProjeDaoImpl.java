/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import com.eticaret.onlinecv.dao.ProjeDao;
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
public class ProjeDaoImpl implements ProjeDao, Serializable{
    
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public List<Proje> getirProjeList() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        List<Proje> list = session.createCriteria(Proje.class)
                .list();
        tx.commit();
        session.close();

        return list;
    }

    @Override
    public Proje getirProje(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
      Proje pro = (Proje) session.get(Proje.class, id);

      session.close();
      return pro;
         }
    
}
