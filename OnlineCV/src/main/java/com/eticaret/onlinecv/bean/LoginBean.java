/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.bean;

import com.eticaret.onlinecv.dao.Impl.KullaniciDaoImpl;
import com.eticaret.onlinecv.dao.Impl.SirketDaoImpl;
import com.eticaret.onlinecv.dao.KullaniciDao;
import com.eticaret.onlinecv.dao.SirketDao;
import com.eticaret.onlinecv.entity.Kullanici;
import com.eticaret.onlinecv.entity.Sirket;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

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
    SirketDao sirketDao = (SirketDao) new SirketDaoImpl();
    
    Sirket s = new Sirket();
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
        Kullanici ku = kullaniciDao.girKontrol(k);

        if (ku != null) {
            k = ku;
            return navigationBean.redirectKullaniciProfil();
        } else {
            System.out.println("giris yanlis");

            return navigationBean.redirectIndex();
        }

    }

    public String girisSKontrol() {
//        Kullanici u = new Kullanici();
//        u.setEmail(k.getEmail());
//        u.setParola(k.getParola());
//    
        Sirket si = sirketDao.girsKontrol(s);

        if (si != null) {
            return navigationBean.redirectSirketProfil();
        } else {
            System.out.println("giriÅŸ yanlÄ±ÅŸ");

            return navigationBean.redirectIndex();
        }

    }
    
    public String logout(){
        Kullanici kisi=null;
        return navigationBean.redirectIndex();
    }
       
    public Kullanici getK() {
        return k;
    }

    public void setK(Kullanici k) {
        this.k = k;
    }
    

    public Sirket getS() {
        return s;
    }

    public void setS(Sirket s) {
        this.s = s;
    }


}
