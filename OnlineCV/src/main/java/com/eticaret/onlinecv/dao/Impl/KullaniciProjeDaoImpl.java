/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import static com.eticaret.onlinecv.bean.HibernateUtil.getSessionFactory;
import com.eticaret.onlinecv.dao.KullaniciProjeDao;
import com.eticaret.onlinecv.entity.Kullanici;
import com.eticaret.onlinecv.entity.Kullaniciproje;
import com.eticaret.onlinecv.entity.Proje;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author esref
 */
public class KullaniciProjeDaoImpl implements KullaniciProjeDao, Serializable {

    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public List<Proje> getirProjeList(Integer kullaniciID) {
//        System.out.println("getirProjeListe girdi");
//        System.out.println(kullaniciID);
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Kullaniciproje> kprojelist  = session.createCriteria(Proje.class)
//                .createAlias("kullaniciprojeList", "kullaniciID")
//                .add(Restrictions.eq("kullaniciID.kullaniciID", kullaniciID))
//                .list();
//        session.close();
//        System.out.println("işlemler tamamlandı");

        String hql = "SELECT p FROM Kullaniciproje kp join kp.projeID p where kp.kullaniciID = " + kullaniciID;

        session = HibernateUtil.getSessionFactory().openSession();

        List<Proje> list;
        Query q = session.createQuery(hql);
//        q.setParameter("kullaniciId", kullaniciID);

        list = q.list();

        session.close();
        return list;
    }

    @Override
    public void kullaniciProjeEkle(Kullaniciproje p) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @Override
    public void kullaniciProjeSil(Kullaniciproje p) {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
        session.close();
    }

}
