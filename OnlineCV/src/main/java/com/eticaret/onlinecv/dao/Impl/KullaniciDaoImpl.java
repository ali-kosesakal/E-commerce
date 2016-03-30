/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import com.eticaret.onlinecv.dao.KullaniciDao;
import com.eticaret.onlinecv.entity.Kullanici;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

/**
 *
 * @author ali
 */
public class KullaniciDaoImpl implements KullaniciDao, Serializable {

    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    //Kullanici giriÅŸi kontrolÃ¼
    @Override
    public Kullanici girKontrol(Kullanici k) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sorgu = "Select k from Kullanici k WHERE email = :email AND parola= :parola";
        System.out.println("    girisyap");

        try {
            System.out.println("    try iÃ§ine girdi1");
            Query q = session.createQuery(sorgu);

            q.setParameter("email", k.getEmail());

            q.setParameter("parola", k.getParola());

            Kullanici u = (Kullanici) q.uniqueResult();

            session.close();
            return u;
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

    @Override
    public boolean kaydet(Kullanici k) {

        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(k.getOzbilgiID());
        session.save(k);
        tx.commit();
        session.close();

        return true;
    }

    @Override
    @Transactional
    public void guncelle(Kullanici k) {

        session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("girdi");
        tx = session.beginTransaction();
        session.update(k.getOzbilgiID());
        session.update(k);
        session.refresh(k);
        tx.commit();
        session.close();
        System.out.println("Kaydetmiş olması lazım :D ");

    }
}
