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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "proje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proje.findAll", query = "SELECT p FROM Proje p"),
    @NamedQuery(name = "Proje.findByProjeID", query = "SELECT p FROM Proje p WHERE p.projeID = :projeID"),
    @NamedQuery(name = "Proje.findByProjeadi", query = "SELECT p FROM Proje p WHERE p.projeadi = :projeadi"),
    @NamedQuery(name = "Proje.findByAciklama", query = "SELECT p FROM Proje p WHERE p.aciklama = :aciklama")})
public class Proje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "projeID")
    private Integer projeID;
    @Size(max = 45)
    @Column(name = "projeadi")
    private String projeadi;
    @Size(max = 300)
    @Column(name = "aciklama")
    private String aciklama;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projeID")
    private List<Kullaniciproje> kullaniciprojeList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "projeID")
    private Projeteknoloji projeteknoloji;

    public Proje() {
    }

    public Proje(Integer projeID) {
        this.projeID = projeID;
    }

    public Integer getProjeID() {
        return projeID;
    }

    public void setProjeID(Integer projeID) {
        this.projeID = projeID;
    }

    public String getProjeadi() {
        return projeadi;
    }

    public void setProjeadi(String projeadi) {
        this.projeadi = projeadi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @XmlTransient
    public List<Kullaniciproje> getKullaniciprojeList() {
        return kullaniciprojeList;
    }

    public void setKullaniciprojeList(List<Kullaniciproje> kullaniciprojeList) {
        this.kullaniciprojeList = kullaniciprojeList;
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
        hash += (projeID != null ? projeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proje)) {
            return false;
        }
        Proje other = (Proje) object;
        if ((this.projeID == null && other.projeID != null) || (this.projeID != null && !this.projeID.equals(other.projeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Proje[ projeID=" + projeID + " ]";
    }
    
}
