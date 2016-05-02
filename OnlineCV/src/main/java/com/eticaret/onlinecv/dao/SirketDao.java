/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao;

import com.eticaret.onlinecv.entity.Sirket;
import com.eticaret.onlinecv.entity.Sirketpozisyon;
import java.util.List;

/**
 *
 * @author ali
 */
public interface SirketDao {
    public Sirket girsKontrol(Sirket s) ;
    public void guncelle(Sirket s);
    public boolean kaydet(Sirket s);
    
    public List<Sirketpozisyon> getirpozisyonList();
   
    
}
