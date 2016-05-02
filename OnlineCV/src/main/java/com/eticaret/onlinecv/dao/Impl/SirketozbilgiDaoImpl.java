/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import com.eticaret.onlinecv.dao.SirketozbilgiDao;
import com.eticaret.onlinecv.entity.Sirketozbilgi;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ali
 */
public class SirketozbilgiDaoImpl implements SirketozbilgiDao, Serializable{
     SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    Session session = null;
    
    Transaction tx = null;
    
    public SirketozbilgiDaoImpl(){
        
    }
    
     @Override
    public void guncelle(Sirketozbilgi s){
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Sirketozbilgi sirketozBilgi = (Sirketozbilgi) session.get(Sirketozbilgi.class,s.getSirketbilgiID());
        tx.commit();
        session.close();
        sirketozBilgi = s;
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = session2.beginTransaction();
        session2.saveOrUpdate(s);
        tx2.commit();
        session2.close();
        
        System.out.println("güncelleme tamamlandı");
    }
}
