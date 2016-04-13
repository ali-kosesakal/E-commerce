/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "basvuru")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Basvuru.findAll", query = "SELECT b FROM Basvuru b"),
    @NamedQuery(name = "Basvuru.findByBasvuruID", query = "SELECT b FROM Basvuru b WHERE b.basvuruID = :basvuruID")})
public class Basvuru implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "basvuruID")
    private Integer basvuruID;
    @JoinColumn(name = "kullaniciID", referencedColumnName = "kullaniciID")
    @ManyToOne(optional = false)
    private Kullanici kullaniciID;
    @JoinColumn(name = "ilanID", referencedColumnName = "ilanID")
    @ManyToOne(optional = false)
    private Ilan ilanID;

    public Basvuru() {
    }

    public Basvuru(Integer basvuruID) {
        this.basvuruID = basvuruID;
    }

    public Integer getBasvuruID() {
        return basvuruID;
    }

    public void setBasvuruID(Integer basvuruID) {
        this.basvuruID = basvuruID;
    }

    public Kullanici getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(Kullanici kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public Ilan getIlanID() {
        return ilanID;
    }

    public void setIlanID(Ilan ilanID) {
        this.ilanID = ilanID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (basvuruID != null ? basvuruID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Basvuru)) {
            return false;
        }
        Basvuru other = (Basvuru) object;
        if ((this.basvuruID == null && other.basvuruID != null) || (this.basvuruID != null && !this.basvuruID.equals(other.basvuruID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Basvuru[ basvuruID=" + basvuruID + " ]";
    }
    
}
