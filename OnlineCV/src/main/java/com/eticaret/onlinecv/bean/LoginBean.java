/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.bean;

import com.eticaret.onlinecv.dao.Impl.KullaniciDaoImpl;
import com.eticaret.onlinecv.dao.KullaniciDao;
import com.eticaret.onlinecv.entity.Kullanici;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author esref
 */
@ManagedBean(name = "loginBean")
@ApplicationScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

   NavigationBean navigationBean = new NavigationBean();
   
   KullaniciDao kullaniciDao = new KullaniciDaoImpl();

    Kullanici k = new Kullanici();

    @PostConstruct

    public void init() {
        System.out.println("calisti");
    }

    public String girisKontrol() throws InterruptedException {
//        Kullanici u = new Kullanici();
//        u.setEmail(k.getEmail());
//        u.setParola(k.getParola());
//System.out.println("calisti");
System.out.println("calisti");
//        k = kullaniciDao.girKontrol(u);
        System.out.println("Giriş kontrole girdi BEAN");
        Kullanici ku = kullaniciDao.girKontrol(k);
       // Thread.sleep(2000);
//        System.out.println(ku.getEmail());
      //  System.out.println(ku.getParola());
       
        
        if (ku != null) {
            return navigationBean.redirectKullaniciProfil();
        } else {
            System.out.println("giriş yanlış");
            return navigationBean.redirectIndex();
        }
    }

    public Kullanici getK() {
        return k;
    }

    public void setK(Kullanici k) {
        this.k = k;
    }

}
