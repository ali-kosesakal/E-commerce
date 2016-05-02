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
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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

    @Override
    public List<Proje> getirSirketProjeList(Integer id) {
         String hql = "SELECT p FROM Sirketproje sp join sp.projeID p where sp.sirketID = "+id;
//         String hql = "SELECT p FROM Projeteknoloji pt join pt.teknolojiID p where pt.projeID = "+id;
       session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
       
        List<Proje> list;
        Query q = session.createQuery(hql);
//        q.setParameter("kullaniciId", kullaniciID);
        list = q.list();

        
    tx.commit();
    session.close();
       return list;
    }
    
}
