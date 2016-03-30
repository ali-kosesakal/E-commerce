/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import com.eticaret.onlinecv.dao.KullaniciDao;
import com.eticaret.onlinecv.dao.KullaniciozbilgiDao;
import com.eticaret.onlinecv.entity.Kullaniciozbilgi;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ali
 */
public class KullaniciozbilgiDaoImpl implements KullaniciozbilgiDao, Serializable{

     SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    
    @Override
    public void guncelle(Kullaniciozbilgi k) {
        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("güncell adres: " + k.getAdres());
        System.out.println("girdi");
        tx = session.beginTransaction();
        session.saveOrUpdate(k);
        tx.commit();
        session.close();
        System.out.println("Kaydetmiş olması lazım :D ");
        }

    
    
}
