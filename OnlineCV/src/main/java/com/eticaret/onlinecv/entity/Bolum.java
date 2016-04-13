/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "bolum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bolum.findAll", query = "SELECT b FROM Bolum b"),
    @NamedQuery(name = "Bolum.findByBolumID", query = "SELECT b FROM Bolum b WHERE b.bolumID = :bolumID"),
    @NamedQuery(name = "Bolum.findByBolumadi", query = "SELECT b FROM Bolum b WHERE b.bolumadi = :bolumadi")})
public class Bolum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bolumID")
    private Integer bolumID;
    @Size(max = 45)
    @Column(name = "bolumadi")
    private String bolumadi;
    @OneToMany(mappedBy = "bolumbolumID")
    private List<Kullaniciozbilgi> kullaniciozbilgiList;

    public Bolum() {
    }

    public Bolum(Integer bolumID) {
        this.bolumID = bolumID;
    }

    public Integer getBolumID() {
        return bolumID;
    }

    public void setBolumID(Integer bolumID) {
        this.bolumID = bolumID;
    }

    public String getBolumadi() {
        return bolumadi;
    }

    public void setBolumadi(String bolumadi) {
        this.bolumadi = bolumadi;
    }

    @XmlTransient
    public List<Kullaniciozbilgi> getKullaniciozbilgiList() {
        return kullaniciozbilgiList;
    }

    public void setKullaniciozbilgiList(List<Kullaniciozbilgi> kullaniciozbilgiList) {
        this.kullaniciozbilgiList = kullaniciozbilgiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bolumID != null ? bolumID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bolum)) {
            return false;
        }
        Bolum other = (Bolum) object;
        if ((this.bolumID == null && other.bolumID != null) || (this.bolumID != null && !this.bolumID.equals(other.bolumID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Bolum[ bolumID=" + bolumID + " ]";
    }
    
}
