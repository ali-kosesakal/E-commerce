/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao;

import com.eticaret.onlinecv.entity.Proje;
import java.util.List;
import com.eticaret.onlinecv.entity.Kullanici;

/**
 *
 * @author ali
 */
public interface ProjeDao {
    
    public List<Proje> getirProjeList();
    
    public Proje getirProje(Integer id);
    
}
