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
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ali
 */
@ManagedBean(name = "sirketBean")
@ViewScoped
public class SirketBean implements Serializable{

    private static final long serialVersionUID = 1L;
    
    NavigationBean navigation = new NavigationBean();
    
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
    
    Pozisyon pozisyon = new Pozisyon();
    
    PozisyonDao pozisyonDao = new PozisyonDaoImpl();
    
    List<Proje> projeList ;
    
    List<Teknoloji> tekList ;
    
    Teknoloji teknoloji = new Teknoloji();
    
    TeknolojiDaoImpl tekDao = new TeknolojiDaoImpl();
    
    HashMap<String,String> teknolojiHash = new HashMap<String, String>();
    
    
    Sirketpozisyon sirketpozisyon = new Sirketpozisyon();
    
    @PostConstruct
    public void init(){
        sirket = login.getS();
        sirketOzbilgi = sirket.getSirketbilgiID();
        projeList = projeDao.getirSirketProjeList(sirket.getSirketID());
       
        
       // System.out.println("        "+ projeList.get(0).getAciklama());05075063987
       // tekList = tekDao.getirProjeTeknoloj();
    }
    
    public String getirTeknoloji(Proje p){
        String teknoloiler = "";
        tekList = tekDao.getirProjeTeknoloj(p.getProjeID());
        int tekId = 0;
        for(Teknoloji t : tekList){
            teknoloiler = teknoloiler + t.getTeknolojiadi() + ", ";
            tekId++;
        }
        return teknoloiler;
    }
    
    public String kaydet(){
        sirket.setSirketbilgiID(sirketOzbilgi);
        sirketDao.kaydet(sirket);
        return navigation.redirectSLogin();
        
        
    }
    
    public void update(){     
        System.out.println(sirket.getSirketbilgiID().getSirketbilgiID());
        sirketOzbilgiDao.guncelle(sirketOzbilgi);
        
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

    public Sirketproje getSirketproje() {
        return sirketproje;
    }

    public void setSirketproje(Sirketproje sirketproje) {
        this.sirketproje = sirketproje;
    }

    public Proje getProje() {
        return proje;
    }

    public void setProje(Proje proje) {
        this.proje = proje;
    }

    public Pozisyon getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(Pozisyon pozisyon) {
        this.pozisyon = pozisyon;
    }

    public List<Proje> getProjeList() {
        return projeList;
    }

    public void setProjeList(List<Proje> projeList) {
        this.projeList = projeList;
    }

    public List<Teknoloji> getTekList() {
        return tekList;
    }

    public void setTekList(List<Teknoloji> tekList) {
        this.tekList = tekList;
    }

    public Sirketpozisyon getSirketpozisyon() {
        return sirketpozisyon;
    }

    public void setSirketpozisyon(Sirketpozisyon sirketpozisyon) {
        this.sirketpozisyon = sirketpozisyon;
    }

    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }

   
   
    
}
