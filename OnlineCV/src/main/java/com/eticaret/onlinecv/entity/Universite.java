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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author esref
 */
@Entity
@Table(name = "universite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Universite.findAll", query = "SELECT u FROM Universite u"),
    @NamedQuery(name = "Universite.findByUniversiteID", query = "SELECT u FROM Universite u WHERE u.universiteID = :universiteID"),
    @NamedQuery(name = "Universite.findByOkuladi", query = "SELECT u FROM Universite u WHERE u.okuladi = :okuladi")})
public class Universite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "universiteID")
    private Integer universiteID;
    @Size(max = 45)
    @Column(name = "okuladi")
    private String okuladi;
    @OneToMany(mappedBy = "universiteID")
    private List<Kullaniciozbilgi> kullaniciozbilgiList;
    @JoinColumn(name = "bolumID", referencedColumnName = "bolumID")
    @ManyToOne
    private Bolum bolumID;

    public Universite() {
    }

    public Universite(Integer universiteID) {
        this.universiteID = universiteID;
    }

    public Integer getUniversiteID() {
        return universiteID;
    }

    public void setUniversiteID(Integer universiteID) {
        this.universiteID = universiteID;
    }

    public String getOkuladi() {
        return okuladi;
    }

    public void setOkuladi(String okuladi) {
        this.okuladi = okuladi;
    }

    @XmlTransient
    public List<Kullaniciozbilgi> getKullaniciozbilgiList() {
        return kullaniciozbilgiList;
    }

    public void setKullaniciozbilgiList(List<Kullaniciozbilgi> kullaniciozbilgiList) {
        this.kullaniciozbilgiList = kullaniciozbilgiList;
    }

    public Bolum getBolumID() {
        return bolumID;
    }

    public void setBolumID(Bolum bolumID) {
        this.bolumID = bolumID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (universiteID != null ? universiteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Universite)) {
            return false;
        }
        Universite other = (Universite) object;
        if ((this.universiteID == null && other.universiteID != null) || (this.universiteID != null && !this.universiteID.equals(other.universiteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Universite[ universiteID=" + universiteID + " ]";
    }
    
}
