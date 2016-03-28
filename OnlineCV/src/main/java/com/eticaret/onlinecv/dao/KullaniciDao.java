/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao;

import com.eticaret.onlinecv.entity.Kullanici;

/**
 *
 * @author ali
 */
public interface KullaniciDao {
    
    public Kullanici girKontrol(Kullanici k);
    
    public boolean kaydet(Kullanici k);
    
}
