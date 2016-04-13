/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.bean;

import com.eticaret.onlinecv.bean.NavigationBean;
import com.eticaret.onlinecv.dao.Impl.SirketDaoImpl;
import com.eticaret.onlinecv.dao.Impl.SirketozbilgiDaoImpl;
import com.eticaret.onlinecv.dao.SirketDao;
import com.eticaret.onlinecv.dao.SirketozbilgiDao;
import com.eticaret.onlinecv.entity.Sirket;
import com.eticaret.onlinecv.entity.Sirketozbilgi;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ali
 */
@ManagedBean(name = "sirketUyeOl")
@ViewScoped
public class SirketBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    NavigationBean navigation = new NavigationBean();
    
    Sirket sirket = new Sirket();
    
    SirketDao sirketDao = new SirketDaoImpl();
    
    Sirketozbilgi sirketozbilgi = new Sirketozbilgi();
    
    SirketozbilgiDao SirketozbilgiDao = new SirketozbilgiDaoImpl();
    
    public void init(){
        
    }
    
    public String kaydet(){
        sirket.setSirketbilgiID(sirketozbilgi);
        sirketDao.kaydet(sirket);
        return navigation.redirectKLogin();
        
        
    }

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    public Sirketozbilgi getSirketozbilgi() {
        return sirketozbilgi;
    }

    public void setSirketozbilgi(Sirketozbilgi sirketozbilgi) {
        this.sirketozbilgi = sirketozbilgi;
    }

    
    
    
    
}
