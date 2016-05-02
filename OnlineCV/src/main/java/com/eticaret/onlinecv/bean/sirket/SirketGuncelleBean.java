/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.bean.sirket;

import com.eticaret.onlinecv.bean.LoginBean;
import com.eticaret.onlinecv.bean.NavigationBean;
import com.eticaret.onlinecv.dao.Impl.PozisyonDaoImpl;
import com.eticaret.onlinecv.dao.Impl.ProjeDaoImpl;
import com.eticaret.onlinecv.dao.Impl.SirketDaoImpl;
import com.eticaret.onlinecv.dao.Impl.SirketProjeDaoImpl;
import com.eticaret.onlinecv.dao.Impl.SirketozbilgiDaoImpl;
import com.eticaret.onlinecv.dao.Impl.TeknolojiDaoImpl;
import com.eticaret.onlinecv.dao.PozisyonDao;
import com.eticaret.onlinecv.dao.ProjeDao;
import com.eticaret.onlinecv.dao.SirketDao;
import com.eticaret.onlinecv.dao.SirketozbilgiDao;
import com.eticaret.onlinecv.dao.SirketprojeDao;
import com.eticaret.onlinecv.entity.Pozisyon;
import com.eticaret.onlinecv.entity.Proje;
import com.eticaret.onlinecv.entity.Sirket;
import com.eticaret.onlinecv.entity.Sirketozbilgi;
import com.eticaret.onlinecv.entity.Sirketpozisyon;
import com.eticaret.onlinecv.entity.Sirketproje;
import com.eticaret.onlinecv.entity.Teknoloji;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
   @ManagedProperty("#{loginBean}")
    private LoginBean login = new LoginBean();

    Sirket sirket = new Sirket();
    
    SirketDao sirketDao = new SirketDaoImpl();
    
    Sirketozbilgi sirketOzbilgi = new Sirketozbilgi();
    
    SirketozbilgiDao sirketOzbilgiDao = new SirketozbilgiDaoImpl();
    
    Sirketproje sirketproje = new Sirketproje();
    
    SirketprojeDao sirketprojeDao = new SirketProjeDaoImpl();
    
    Proje proje = new Proje();
    
    ProjeDao projeDao = new ProjeDaoImpl();
    
    List<Pozisyon> pozliste = new ArrayList<Pozisyon>();
    
    Pozisyon pozisyon = new Pozisyon();
    
    PozisyonDao pozisyonDao = new PozisyonDaoImpl();
    
    List<Proje> projeList ;
    
    List<Teknoloji> tekList ;
    
    TeknolojiDaoImpl tekDao = new TeknolojiDaoImpl();
    
    
    Sirketpozisyon sirketpozisyon = new Sirketpozisyon();
    
    public SirketGuncelleBean() {
    }
   
   @PostConstruct
    public void init(){
        sirket = login.getS();
        sirketOzbilgi = sirket.getSirketbilgiID();
        System.out.println(sirketOzbilgi.getSirketadi());
        System.out.println(sirket.getEmail());
        projeList = projeDao.getirSirketProjeList(sirket.getSirketID());
        System.out.println("        "+ projeList.get(0).getAciklama());
        tekList = tekDao.getirProjeTeknoloj(Integer.SIZE);
        System.out.println("    teknolojiler"+ tekList.get(0).getTeknolojiadi());
        
        
    }
    
    public void update(){     
        System.out.println(sirket.getSirketbilgiID().getSirketbilgiID());
        sirketOzbilgiDao.guncelle(sirketOzbilgi);
        
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

    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }

    public Sirketproje getSirketproje() {
        return sirketproje;
    }

    public void setSirketproje(Sirketproje sirketproje) {
        this.sirketproje = sirketproje;
    }
    
    public Pozisyon getfromlist(){
        return null;
    }

    public List<Proje> getProjeList() {
        return projeList;
    }

    public void setProjeList(List<Proje> projeList) {
        this.projeList = projeList;
    }

    public Proje getProje() {
        return proje;
    }

    public void setProje(Proje proje) {
        this.proje = proje;
    }

    public List<Teknoloji> getTekList() {
        return tekList;
    }

    public void setTekList(List<Teknoloji> tekList) {
        this.tekList = tekList;
    }

    public TeknolojiDaoImpl getTekDao() {
        return tekDao;
    }

    public void setTekDao(TeknolojiDaoImpl tekDao) {
        this.tekDao = tekDao;
    }
    
    
  
}
