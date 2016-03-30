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
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author esref
 */
@ManagedBean(name = "uyeOl")
@ViewScoped
public class UyeOl implements Serializable{
     private static final long serialVersionUID = 1L;
    
    NavigationBean navigationBean = new NavigationBean();
    
    KullaniciozbilgiDao kullaniciOzDao = new KullaniciozbilgiDaoImpl();
    
    Kullaniciozbilgi kozbilgi=new Kullaniciozbilgi();
    
    Kullanici kullanici = new Kullanici();
    
    KullaniciDao kullaniciDao = new KullaniciDaoImpl();
    
   

    /**
     * Creates a new instance of UyeOl
     */
    public void init() {
        
    }
    
    
    public String kaydet(){
       kullanici.setOzbilgiID(kozbilgi);
       kullaniciDao.kaydet(kullanici);
       return navigationBean.redirectKLogin();
    }

    public Kullaniciozbilgi getKozbilgi() {
        return kozbilgi;
    }

    public void setKozbilgi(Kullaniciozbilgi kozbilgi) {
        this.kozbilgi = kozbilgi;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
    
     
}
