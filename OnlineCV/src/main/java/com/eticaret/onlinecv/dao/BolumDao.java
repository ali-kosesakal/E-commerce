/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao;

//import com.eticaret.onlinecv.entity.Bolum;
import com.eticaret.onlinecv.entity.Bolum;
import java.util.List;

/**
 *
 * @author ali
 */
public interface BolumDao {

    public List<Bolum> getirBolumList();

    public Bolum getirBolum(Integer id);

}
