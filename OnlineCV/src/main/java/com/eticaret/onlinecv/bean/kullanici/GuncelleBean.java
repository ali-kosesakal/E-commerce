/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.bean.kullanici;

import com.eticaret.onlinecv.bean.LoginBean;
import com.eticaret.onlinecv.bean.NavigationBean;
import com.eticaret.onlinecv.dao.Impl.KullaniciDaoImpl;
import com.eticaret.onlinecv.dao.Impl.KullaniciozbilgiDaoImpl;
import com.eticaret.onlinecv.dao.Impl.ProjeDaoImpl;
import com.eticaret.onlinecv.dao.Impl.UniversiteDaoImpl;
import com.eticaret.onlinecv.dao.KullaniciDao;
import com.eticaret.onlinecv.dao.KullaniciozbilgiDao;
import com.eticaret.onlinecv.dao.ProjeDao;
import com.eticaret.onlinecv.dao.UniversiteDao;
import com.eticaret.onlinecv.entity.Kullanici;
import com.eticaret.onlinecv.entity.Kullaniciozbilgi;
import com.eticaret.onlinecv.entity.Kullaniciproje;
import com.eticaret.onlinecv.entity.Proje;
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
    private LoginBean loku = new LoginBean();
    
    KullaniciozbilgiDao kullaniciOzDao = new KullaniciozbilgiDaoImpl();
    
    KullaniciDao kullaniciDao = new KullaniciDaoImpl();
    
    UniversiteDao uniDao = new UniversiteDaoImpl();
    
    ProjeDao projeDao = new ProjeDaoImpl();
    
    Kullanici guncelk = new Kullanici();
    
    Universite universite = new Universite();
    
    Kullaniciozbilgi guncelozbilgi = new Kullaniciozbilgi();
    
    Kullaniciozbilgi guncelozbilgi2 = new Kullaniciozbilgi();
    
    Proje proje = new Proje();
    
    Kullaniciproje kulproje = new Kullaniciproje();
    
    List<Proje> projelist;
    
    List<Kullaniciproje> kulProjeList;
    
    List<Universite> universiteListe;
    
    Integer guncelUniId;

    /**
     * Creates a new instance of GuncelleKullanici
     */
    @PostConstruct
    public void init() {
        guncelozbilgi = loku.getK().getOzbilgiID();
        universiteListe = uniDao.getirUniversiteList();
//        projelist = projeDao.getirKullaniciProjeList(loku.getK().getKullaniciID());
        System.out.println("        "+ projelist.get(0).getAciklama());
//        kulProjeList = guncelk.getKullaniciprojeList();
    }
    
    public void update() {
        System.out.println("update girdi");        
        System.out.println(guncelozbilgi.getAdres());
        System.out.println(guncelozbilgi.getAciklama());
        Universite gUni = uniDao.getirUniversite(guncelUniId);
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
    
    public Kullaniciozbilgi getGuncelozbilgi2() {
        return guncelozbilgi2;
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

    public Proje getProje() {
        return proje;
    }

    public void setProje(Proje proje) {
        this.proje = proje;
    }

    public List<Proje> getProjelist() {
        return projelist;
    }

    public void setProjelist(List<Proje> projelist) {
        this.projelist = projelist;
    }

    public Kullaniciproje getKulproje() {
        return kulproje;
    }

    public void setKulproje(Kullaniciproje kulproje) {
        this.kulproje = kulproje;
    }

    public List<Kullaniciproje> getKulProjeList() {
        return kulProjeList;
    }

    public void setKulProjeList(List<Kullaniciproje> kulProjeList) {
        this.kulProjeList = kulProjeList;
    }
    
    
}
