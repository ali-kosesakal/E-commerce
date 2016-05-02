/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.bean;

import com.eticaret.onlinecv.dao.Impl.KullaniciProjeDaoImpl;
import com.eticaret.onlinecv.entity.Proje;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author esref
 */
@ManagedBean(name = "testBean")
public class TestBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{loginBean}")
    LoginBean loku;

    List<Proje> projeList;
    KullaniciProjeDaoImpl kpdap = new KullaniciProjeDaoImpl();

    @PostConstruct
    public void init() {
        projeList = kpdap.getirProjeList(loku.k.getKullaniciID());
        System.out.println(loku.k.getKullaniciID());
    }

    public List<Proje> getProjeList() {
        return projeList;
    }

    public void setProjeList(List<Proje> projeList) {
        this.projeList = projeList;
    }

    public LoginBean getLoku() {
        return loku;
    }

    public void setLoku(LoginBean loku) {
        this.loku = loku;
    }

}
