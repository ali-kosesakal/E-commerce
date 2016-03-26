/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import com.eticaret.onlinecv.dao.KullaniciDao;
import com.eticaret.onlinecv.entity.Kullanici;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

/**
 *
 * @author ali
 */
public class KullaniciDaoImpl implements KullaniciDao {

    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    //Kullanici girişi kontrolü
    @Override
    public Kullanici girKontrol(Kullanici k) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();        
        String sorgu = "Select u from Kullanici u WHERE k_email = :email AND k_parola= :parola";
        System.out.println("    girisyap");
        try {
            Query q = session.createQuery(sorgu);
            q.setParameter("k_email", k.getEmail());
            q.setParameter("k_parola", k.getParola());

            Kullanici u = (Kullanici) q.uniqueResult();
            System.out.println("    try içine girdi");

            session.close();
            return u;
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

}
