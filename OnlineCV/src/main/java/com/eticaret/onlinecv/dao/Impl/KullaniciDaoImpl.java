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
//
//    public void save(Kullanici user) {
//        session.beginTransaction();
//        session.save(user);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    public Integer getId() {
//        String hql = "select count(kullaniciID) from kullanici k";
//        Query query = session.createQuery(hql);
//        List<Integer> results = new ArrayList<>();
//
//        results = query.list();
//        Integer kullan = 1;
//        if (results.get(0) != null) {
//            System.out.print(kullan);
//            kullan = results.get(0) + 1;
//        }
//        System.out.print(kullan);
//        return kullan;
//    }

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
}
