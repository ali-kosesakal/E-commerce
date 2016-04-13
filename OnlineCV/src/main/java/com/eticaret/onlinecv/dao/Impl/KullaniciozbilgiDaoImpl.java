/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
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
public class KullaniciozbilgiDaoImpl implements KullaniciozbilgiDao, Serializable {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    Session session = null;
    Transaction tx = null;

    @Override
    public void guncelle(Kullaniciozbilgi k) {
        session = sessionFactory.openSession();
        System.out.println("güncell adres: " + k.getAdres());
        System.out.println("girdi");
        System.out.println("                -"+k.getTel());
        tx = session.beginTransaction();

        Kullaniciozbilgi ozbilgi = (Kullaniciozbilgi) session.get(Kullaniciozbilgi.class, k.getOzbilgiID());

        tx.commit();

        session.close();

        ozbilgi = k;

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = session2.beginTransaction();
        session2.merge(ozbilgi);
        tx2.commit();
        session2.close();

        System.out.println("Kaydetmiş olması lazım :D ");
    }

}
