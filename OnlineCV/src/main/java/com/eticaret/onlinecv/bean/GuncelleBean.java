/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.bean;

import com.eticaret.onlinecv.dao.Impl.KullaniciDaoImpl;
import com.eticaret.onlinecv.dao.Impl.KullaniciozbilgiDaoImpl;
import com.eticaret.onlinecv.dao.KullaniciDao;
import com.eticaret.onlinecv.dao.KullaniciozbilgiDao;
import com.eticaret.onlinecv.entity.Kullanici;
import com.eticaret.onlinecv.entity.Kullaniciozbilgi;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author esref
 */
@ManagedBean(name = "guncelleBean")
@ViewScoped
public class GuncelleBean implements Serializable{

    NavigationBean navigationBean = new NavigationBean();
    
    
    @ManagedProperty("#{loginBean}")
    private LoginBean loku= new LoginBean();
    
    KullaniciozbilgiDao kullaniciOzDao = new KullaniciozbilgiDaoImpl();

    KullaniciDao kullaniciDao = new KullaniciDaoImpl();

    Kullanici guncelk = new Kullanici();

    Kullaniciozbilgi guncelozbilgi = new Kullaniciozbilgi();
    
    Kullaniciozbilgi guncelozbilgi2 = new Kullaniciozbilgi();

    /**
     * Creates a new instance of GuncelleKullanici
     */
    @PostConstruct
    public void init() {
                guncelozbilgi = loku.k.getOzbilgiID();       
    }

    public void update() {
        System.out.println("update girdi"); 
        System.out.println(guncelozbilgi.getAdres());
        System.out.println(guncelozbilgi.getAciklama());
        kullaniciOzDao.guncelle(guncelozbilgi);
        
    }

    public Kullanici getGuncelk() {
        return guncelk;
    }

    public void setGuncelk(Kullanici guncelk) {
        this.guncelk = guncelk;
    }

    public Kullaniciozbilgi getGuncelozbilgi() {
        return guncelozbilgi;
    }

    public void setGuncelozbilgi(Kullaniciozbilgi guncelozbilgi) {
        this.guncelozbilgi = guncelozbilgi;
    }

    public void setLoku(LoginBean loku) {
        this.loku = loku;
    }

    public LoginBean getLoku() {
        return loku;
    }

    public Kullaniciozbilgi getGuncelozbilgi2() {
        return guncelozbilgi2;
    }

  
    
    
}
