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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author esref
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

   NavigationBean navigationBean = new NavigationBean();
   
   KullaniciDao kullaniciDao = new KullaniciDaoImpl();

    Kullanici k = new Kullanici();

    @PostConstruct

    public void init() {
        System.out.println("calisti");
    }

    public String girisKontrol() {
//        Kullanici u = new Kullanici();
//        u.setEmail(k.getEmail());
//        u.setParola(k.getParola());
//
//        k = kullaniciDao.girKontrol(u);
        Kullanici ku = kullaniciDao.girKontrol(k);
        if (k != null) {
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
