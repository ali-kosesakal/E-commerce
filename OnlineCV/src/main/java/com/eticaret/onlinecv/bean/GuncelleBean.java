/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.bean;

import com.eticaret.onlinecv.dao.BolumDao;
import com.eticaret.onlinecv.dao.Impl.BolumDaoImpl;
import com.eticaret.onlinecv.dao.Impl.KullaniciProjeDaoImpl;
import com.eticaret.onlinecv.dao.Impl.KullaniciozbilgiDaoImpl;
import com.eticaret.onlinecv.dao.Impl.ProjeDaoImpl;
import com.eticaret.onlinecv.dao.Impl.ProjeteknolojiDaoImpl;
import com.eticaret.onlinecv.dao.Impl.UniversiteDaoImpl;
import com.eticaret.onlinecv.dao.KullaniciProjeDao;
import com.eticaret.onlinecv.dao.KullaniciozbilgiDao;
import com.eticaret.onlinecv.dao.ProjeDao;
import com.eticaret.onlinecv.dao.ProjeteknolojiDao;
import com.eticaret.onlinecv.dao.UniversiteDao;
import com.eticaret.onlinecv.entity.Bolum;
import com.eticaret.onlinecv.entity.Kullanici;
import com.eticaret.onlinecv.entity.Kullaniciozbilgi;
import com.eticaret.onlinecv.entity.Kullaniciproje;
import com.eticaret.onlinecv.entity.Proje;
import com.eticaret.onlinecv.entity.Projeteknoloji;
import com.eticaret.onlinecv.entity.Teknoloji;
import com.eticaret.onlinecv.entity.Universite;
import java.io.Serializable;
import java.util.List;
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
public class GuncelleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    NavigationBean navigationBean = new NavigationBean();

    @ManagedProperty("#{loginBean}")
    LoginBean loku = new LoginBean();

    KullaniciozbilgiDao kullaniciOzDao = new KullaniciozbilgiDaoImpl();

    UniversiteDao uniDao = new UniversiteDaoImpl();
    
    BolumDao bolumDao = new BolumDaoImpl();
    
    Kullanici guncelk = new Kullanici();

    Universite universite = new Universite();

    Kullaniciozbilgi guncelozbilgi = new Kullaniciozbilgi();

    List<Universite> universiteListe;
    
    List<Bolum> bolumListe;
    
    Integer guncelBolumId;

    Integer guncelUniId;

    /**
     * Creates a new instance of GuncelleKullanici
     */
    @PostConstruct
    public void init() {
        guncelozbilgi = loku.k.getOzbilgiID();
        universiteListe = uniDao.getirUniversiteList();
        bolumListe = bolumDao.getirBolumList();
    }

    public void update() {
        Universite gUni = uniDao.getirUniversite(guncelUniId);
        Bolum gBolum = bolumDao.getirBolum(guncelBolumId);
        guncelozbilgi.setBolumbolumID(gBolum);
        guncelozbilgi.setUniversiteID(gUni);
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

    public List<Universite> getUniversiteListe() {
        return universiteListe;
    }

    public void setUniversiteListe(List<Universite> universiteListe) {
        this.universiteListe = universiteListe;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public Integer getGuncelUniId() {
        return guncelUniId;
    }

    public void setGuncelUniId(Integer guncelUniId) {
        this.guncelUniId = guncelUniId;
    }

    public List<Bolum> getBolumListe() {
        return bolumListe;
    }

    public void setBolumListe(List<Bolum> bolumListe) {
        this.bolumListe = bolumListe;
    }

    public Integer getGuncelBolumId() {
        return guncelBolumId;
    }

    public void setGuncelBolumId(Integer guncelBolumId) {
        this.guncelBolumId = guncelBolumId;
    }

}
