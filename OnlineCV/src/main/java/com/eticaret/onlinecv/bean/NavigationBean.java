/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author esref
 */
@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable{

    /**
     * Creates a new instance of NavigationBean
     */
    private static final long serialVersionUID = 1L;
    
   public String redirectIndex() {
      return "/index?faces-redirect=true";
   }

   public String toIndex() {
      return "/index.xhtml";
   }

   public String redirectKLogin() {
      return "/kullanici/giris?faces-redirect=true";
   }
   
   public String toKLogin(){
       return "/kullanici/giris.xhtml";
   }

   public String redirectSLogin() {
      return "/sirket/giris?faces-redirect=true";
   }
   
    public String redirectKullaniciProfil() {
      return "/kullanici/profil?faces-redirect=true";
   }
    
    public String toKProfil(){
        return "/kullanici/profil.xhtml";
    }
    
    public String redirectSirketProfil() {
      return "/sirket/sirketProfil?faces-redirect=true";
   }
    
    public String redirectPozisyon(){
        return "/sirket/pozisyon?faces-redirect=true";
    }
}