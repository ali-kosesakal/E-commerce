/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao;

import com.eticaret.onlinecv.entity.Kullanici;
import com.eticaret.onlinecv.entity.Kullaniciproje;
import com.eticaret.onlinecv.entity.Proje;
import java.util.List;

/**
 *
 * @author esref
 */
public interface KullaniciProjeDao {
    

    public List<Proje> getirProjeList(Integer kullaniciID);

    public void kullaniciProjeEkle(Kullaniciproje p);
    
    public void kullaniciProjeSil(Kullaniciproje p);
}
