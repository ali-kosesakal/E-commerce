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
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author esref
 */
@ManagedBean(name = "guncelleKullanici")
@ViewScoped
public class GuncelleKullanici {

    NavigationBean navigationBean = new NavigationBean();

    KullaniciozbilgiDao kullaniciOzDao = new KullaniciozbilgiDaoImpl();

    KullaniciDao kullaniciDao = new KullaniciDaoImpl();

    Kullanici guncelk = new Kullanici();

    Kullaniciozbilgi guncelozbilgi = new Kullaniciozbilgi();

    /**
     * Creates a new instance of GuncelleKullanici
     */
    @PostConstruct
    public void init() {
        LoginBean k = new LoginBean();
        guncelozbilgi = k.k.getOzbilgiID();
    }

    public String update() {
        
        guncelk.setOzbilgiID(guncelozbilgi);
        kullaniciDao.guncelle(guncelk);
        return navigationBean.redirectKullaniciProfil();

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

}
