/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import com.eticaret.onlinecv.dao.SirketDao;
import com.eticaret.onlinecv.entity.Kullanici;
import com.eticaret.onlinecv.entity.Proje;
import com.eticaret.onlinecv.entity.Sirket;
import com.eticaret.onlinecv.entity.Sirketpozisyon;
import com.eticaret.onlinecv.entity.Sirketproje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ali
 */
public class SirketDaoImpl implements SirketDao, Serializable {

    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public Sirket girsKontrol(Sirket s) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sorgu = "Select s from Sirket s WHERE email = :email AND parola= :parola";
        System.out.println("    girisyap");

        try {
            Query q = session.createQuery(sorgu);

            q.setParameter("email", s.getEmail());

            q.setParameter("parola", s.getParola());

            Sirket u = (Sirket) q.uniqueResult();

            session.close();
            return u;
        } catch (Exception e) {
            session.close();
            return null;
        }
    }
    
    @Override
    public boolean kaydet(Sirket s) {
         session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(s.getSirketbilgiID());
        session.save(s);
        tx.commit();
        session.close();
        return true;
        
    }

    @Override
    public void guncelle(Sirket s) {
        System.out.println(s.getEmail());
        System.out.println(s.getParola());
        System.out.println(s.getSirketbilgiID().getSirketbilgiID());
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.merge(s);
        tx.commit();
        session.close();
        System.out.println("guncelleme işlemi tamamlandı.....");
        
    }

   
    @Override
    public List<Sirketpozisyon> getirpozisyonList() {
         session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Sirket s = new Sirket();
        List<Sirketpozisyon> pozisyonListe = session.createCriteria(Sirketpozisyon.class).list();
        tx.commit();
        session.close();
        
        return pozisyonListe;
    }

   
}