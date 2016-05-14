/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.bean;

import com.eticaret.onlinecv.dao.Impl.KullaniciProjeDaoImpl;
import com.eticaret.onlinecv.dao.Impl.ProjeDaoImpl;
import com.eticaret.onlinecv.dao.KullaniciProjeDao;
import com.eticaret.onlinecv.dao.ProjeDao;
import com.eticaret.onlinecv.entity.Kullaniciproje;
import com.eticaret.onlinecv.entity.Proje;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author esref
 */
@ManagedBean(name = "kullaniciProjeBean")
@ViewScoped
public class KullaniciProjeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{loginBean}")
    LoginBean loku = new LoginBean();

    List<Proje> kulProjeList;

    Kullaniciproje kulproje = new Kullaniciproje();

    Kullaniciproje kulproje2 = new Kullaniciproje();

    KullaniciProjeDao kulProjeDao = new KullaniciProjeDaoImpl();

    ProjeDao projeDao = new ProjeDaoImpl();

    Proje projeekle = new Proje();
    Proje projeGuncelle = new Proje();
    Integer projeID;

    @PostConstruct
    public void init() {
        kulProjeList = kulProjeDao.getirProjeList(loku.k.getKullaniciID());
    }

    public void projeEkle() {
        projeDao.projeEkle(projeekle);
        kulproje2.setKullaniciID(loku.k);
        kulproje2.setProjeID(projeekle);
        kulProjeDao.kullaniciProjeEkle(kulproje2);
        kulProjeList.add(projeekle);
        temizle();
    }

    public void projeIdGetir(Proje p) {
        projeGuncelle = p;
        System.out.println("proje Id =" + projeGuncelle.getProjeID());
    }

    public void projeUpdate() {
        projeDao.projeGuncelle(projeGuncelle);
        temizle();
        
    }

    public void projeSil(Proje p) {
        kulproje2.setKullaniciID(loku.k);
        kulproje2.setProjeID(p);
        projeDao.projeSil(p);
        kulProjeDao.kullaniciProjeSil(kulproje2);
        kulProjeList.remove(p);
    }
    
    public void temizle(){
        projeGuncelle = new Proje();
        projeekle = new Proje();
    }

    public void silMesaj() {
        addMessage("Veritabanı Bilgilendirme", "Projeniz başarıyla silindi.");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public LoginBean getLoku() {
        return loku;
    }

    public void setLoku(LoginBean loku) {
        this.loku = loku;
    }

    public List<Proje> getKulProjeList() {
        return kulProjeList;
    }

    public void setKulProjeList(List<Proje> kulProjeList) {
        this.kulProjeList = kulProjeList;
    }

    public Proje getProjeekle() {
        return projeekle;
    }

    public void setProjeekle(Proje projeekle) {
        this.projeekle = projeekle;
    }

    public Kullaniciproje getKulproje2() {
        return kulproje2;
    }

    public void setKulproje2(Kullaniciproje kulproje2) {
        this.kulproje2 = kulproje2;
    }

    public Proje getProjeGuncelle() {
        return projeGuncelle;
    }

    public void setProjeGuncelle(Proje projeGuncelle) {
        this.projeGuncelle = projeGuncelle;
    }

}
