/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author esref
 */
@Entity
@Table(name = "pozisyon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pozisyon.findAll", query = "SELECT p FROM Pozisyon p"),
    @NamedQuery(name = "Pozisyon.findByPozisyonID", query = "SELECT p FROM Pozisyon p WHERE p.pozisyonID = :pozisyonID"),
    @NamedQuery(name = "Pozisyon.findByPozisyonadi", query = "SELECT p FROM Pozisyon p WHERE p.pozisyonadi = :pozisyonadi")})
public class Pozisyon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pozisyonID")
    private Integer pozisyonID;
    @Size(max = 45)
    @Column(name = "pozisyonadi")
    private String pozisyonadi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pozisyonID")
    private List<Sirketpozisyon> sirketpozisyonList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pozisyonID")
    private List<Pozisyonilan> pozisyonilanList;

    public Pozisyon() {
    }

    public Pozisyon(Integer pozisyonID) {
        this.pozisyonID = pozisyonID;
    }

    public Integer getPozisyonID() {
        return pozisyonID;
    }

    public void setPozisyonID(Integer pozisyonID) {
        this.pozisyonID = pozisyonID;
    }

    public String getPozisyonadi() {
        return pozisyonadi;
    }

    public void setPozisyonadi(String pozisyonadi) {
        this.pozisyonadi = pozisyonadi;
    }

    @XmlTransient
    public List<Sirketpozisyon> getSirketpozisyonList() {
        return sirketpozisyonList;
    }

    public void setSirketpozisyonList(List<Sirketpozisyon> sirketpozisyonList) {
        this.sirketpozisyonList = sirketpozisyonList;
    }

    @XmlTransient
    public List<Pozisyonilan> getPozisyonilanList() {
        return pozisyonilanList;
    }

    public void setPozisyonilanList(List<Pozisyonilan> pozisyonilanList) {
        this.pozisyonilanList = pozisyonilanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pozisyonID != null ? pozisyonID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pozisyon)) {
            return false;
        }
        Pozisyon other = (Pozisyon) object;
        if ((this.pozisyonID == null && other.pozisyonID != null) || (this.pozisyonID != null && !this.pozisyonID.equals(other.pozisyonID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Pozisyon[ pozisyonID=" + pozisyonID + " ]";
    }
    
}
