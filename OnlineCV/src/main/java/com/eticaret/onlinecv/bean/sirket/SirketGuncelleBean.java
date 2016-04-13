/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.bean.sirket;

import com.eticaret.onlinecv.bean.LoginBean;
import com.eticaret.onlinecv.bean.LoginBean;
import com.eticaret.onlinecv.bean.NavigationBean;
import com.eticaret.onlinecv.bean.NavigationBean;
import com.eticaret.onlinecv.dao.Impl.SirketDaoImpl;
import com.eticaret.onlinecv.dao.Impl.SirketozbilgiDaoImpl;
import com.eticaret.onlinecv.dao.SirketDao;
import com.eticaret.onlinecv.dao.SirketozbilgiDao;
import com.eticaret.onlinecv.entity.Sirket;
import com.eticaret.onlinecv.entity.Sirketozbilgi;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ali
 */
@ManagedBean(name = "sirketGuncelleBean")
@ViewScoped
public class SirketGuncelleBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    NavigationBean navigationBean = new NavigationBean();
    
    private LoginBean login = new LoginBean();

    Sirket sirket = new Sirket();
    
    SirketDao sirketDao = new SirketDaoImpl();
    
    Sirketozbilgi sirketOzbilgi = new Sirketozbilgi();
    
    SirketozbilgiDao sirketOzbilgiDao = new SirketozbilgiDaoImpl();
    
    public SirketGuncelleBean() {
    }
   
    @PostConstruct
    public void init(){
        sirket = login.getS();
        sirketOzbilgi = sirket.getSirketbilgiID();
    }
    
    public void update(){
        System.out.println("Şirket Güncelleye girdi");
        System.out.println(sirket.getEmail());
        System.out.println(sirket.getParola());
        System.out.println(sirket.getSirketbilgiID().getSirketbilgiID());
        sirketDao.guncelle(sirket);
    }

    public NavigationBean getNavigationBean() {
        return navigationBean;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    public Sirketozbilgi getSirketOzbilgi() {
        return sirketOzbilgi;
    }

    public void setSirketOzbilgi(Sirketozbilgi sirketOzbilgi) {
        this.sirketOzbilgi = sirketOzbilgi;
    }
    
    
}
