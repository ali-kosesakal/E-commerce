/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao.Impl;

import com.eticaret.onlinecv.bean.HibernateUtil;
import com.eticaret.onlinecv.dao.SirketozbilgiDao;
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
    
    public void guncelle(){
        
    }
    
}
