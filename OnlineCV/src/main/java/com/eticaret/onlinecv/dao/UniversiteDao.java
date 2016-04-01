/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.dao;

import com.eticaret.onlinecv.entity.Universite;
import java.util.List;

/**
 *
 * @author ali
 */
public interface UniversiteDao {

    public List<Universite> getirUniversiteList();

    public Universite getirUniversite(Integer id);
}
