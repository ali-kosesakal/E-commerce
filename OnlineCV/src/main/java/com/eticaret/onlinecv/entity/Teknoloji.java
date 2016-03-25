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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "teknoloji")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teknoloji.findAll", query = "SELECT t FROM Teknoloji t"),
    @NamedQuery(name = "Teknoloji.findByTeknolojiID", query = "SELECT t FROM Teknoloji t WHERE t.teknolojiID = :teknolojiID"),
    @NamedQuery(name = "Teknoloji.findByTeknolojiadi", query = "SELECT t FROM Teknoloji t WHERE t.teknolojiadi = :teknolojiadi"),
    @NamedQuery(name = "Teknoloji.findByAciklama", query = "SELECT t FROM Teknoloji t WHERE t.aciklama = :aciklama")})
public class Teknoloji implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "teknolojiID")
    private Integer teknolojiID;
    @Size(max = 45)
    @Column(name = "teknolojiadi")
    private String teknolojiadi;
    @Size(max = 45)
    @Column(name = "aciklama")
    private String aciklama;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teknolojiID")
    private List<Sirketteknoloji> sirketteknolojiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teknolojiID")
    private List<Ilanteknoloji> ilanteknolojiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teknolojiID")
    private List<Sprojetek> sprojetekList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teknolojiID")
    private List<Kullaniciteknoloji> kullaniciteknolojiList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teknolojiID")
    private Projeteknoloji projeteknoloji;

    public Teknoloji() {
    }

    public Teknoloji(Integer teknolojiID) {
        this.teknolojiID = teknolojiID;
    }

    public Integer getTeknolojiID() {
        return teknolojiID;
    }

    public void setTeknolojiID(Integer teknolojiID) {
        this.teknolojiID = teknolojiID;
    }

    public String getTeknolojiadi() {
        return teknolojiadi;
    }

    public void setTeknolojiadi(String teknolojiadi) {
        this.teknolojiadi = teknolojiadi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @XmlTransient
    public List<Sirketteknoloji> getSirketteknolojiList() {
        return sirketteknolojiList;
    }

    public void setSirketteknolojiList(List<Sirketteknoloji> sirketteknolojiList) {
        this.sirketteknolojiList = sirketteknolojiList;
    }

    @XmlTransient
    public List<Ilanteknoloji> getIlanteknolojiList() {
        return ilanteknolojiList;
    }

    public void setIlanteknolojiList(List<Ilanteknoloji> ilanteknolojiList) {
        this.ilanteknolojiList = ilanteknolojiList;
    }

    @XmlTransient
    public List<Sprojetek> getSprojetekList() {
        return sprojetekList;
    }

    public void setSprojetekList(List<Sprojetek> sprojetekList) {
        this.sprojetekList = sprojetekList;
    }

    @XmlTransient
    public List<Kullaniciteknoloji> getKullaniciteknolojiList() {
        return kullaniciteknolojiList;
    }

    public void setKullaniciteknolojiList(List<Kullaniciteknoloji> kullaniciteknolojiList) {
        this.kullaniciteknolojiList = kullaniciteknolojiList;
    }

    public Projeteknoloji getProjeteknoloji() {
        return projeteknoloji;
    }

    public void setProjeteknoloji(Projeteknoloji projeteknoloji) {
        this.projeteknoloji = projeteknoloji;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teknolojiID != null ? teknolojiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teknoloji)) {
            return false;
        }
        Teknoloji other = (Teknoloji) object;
        if ((this.teknolojiID == null && other.teknolojiID != null) || (this.teknolojiID != null && !this.teknolojiID.equals(other.teknolojiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Teknoloji[ teknolojiID=" + teknolojiID + " ]";
    }
    
}
