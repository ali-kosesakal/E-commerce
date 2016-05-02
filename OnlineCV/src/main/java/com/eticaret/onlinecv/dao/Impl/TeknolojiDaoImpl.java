/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import com.eticaret.onlinecv.dao.TeknolojDao;
import com.eticaret.onlinecv.entity.Proje;
import com.eticaret.onlinecv.entity.Teknoloji;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ali
 */
public class TeknolojiDaoImpl implements Serializable, TeknolojDao{
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;

    @Override
    public List<Teknoloji> getirProjeTeknoloj(Integer id) {
        System.out.println("projeID======>>>"+ id);
        String hql = "SELECT t FROM Projeteknoloji pt join pt.teknolojiID t where pt.projeID = "+id;
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        
         List<Teknoloji> list;
        Query q = session.createQuery(hql);
//        q.setParameter("kullaniciId", kullaniciID);
        list = q.list();

        
    tx.commit();
    session.close();
       return list;
        
    }
    
    
    
}
