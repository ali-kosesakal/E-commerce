/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "ilan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ilan.findAll", query = "SELECT i FROM Ilan i"),
    @NamedQuery(name = "Ilan.findByIlanID", query = "SELECT i FROM Ilan i WHERE i.ilanID = :ilanID"),
    @NamedQuery(name = "Ilan.findByIlanbaslik", query = "SELECT i FROM Ilan i WHERE i.ilanbaslik = :ilanbaslik"),
    @NamedQuery(name = "Ilan.findByIlanaciklama", query = "SELECT i FROM Ilan i WHERE i.ilanaciklama = :ilanaciklama"),
    @NamedQuery(name = "Ilan.findByIlanbastarihi", query = "SELECT i FROM Ilan i WHERE i.ilanbastarihi = :ilanbastarihi"),
    @NamedQuery(name = "Ilan.findByIlanbittarihi", query = "SELECT i FROM Ilan i WHERE i.ilanbittarihi = :ilanbittarihi")})
public class Ilan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ilanID")
    private Integer ilanID;
    @Size(max = 45)
    @Column(name = "ilanbaslik")
    private String ilanbaslik;
    @Size(max = 45)
    @Column(name = "ilanaciklama")
    private String ilanaciklama;
    @Column(name = "ilanbastarihi")
    @Temporal(TemporalType.DATE)
    private Date ilanbastarihi;
    @Column(name = "ilanbittarihi")
    @Temporal(TemporalType.DATE)
    private Date ilanbittarihi;
    @JoinColumn(name = "sirketID", referencedColumnName = "sirketID")
    @ManyToOne(optional = false)
    private Sirket sirketID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ilanID")
    private List<Basvuru> basvuruList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ilanID")
    private List<Ilanteknoloji> ilanteknolojiList;

    public Ilan() {
    }

    public Ilan(Integer ilanID) {
        this.ilanID = ilanID;
    }

    public Integer getIlanID() {
        return ilanID;
    }

    public void setIlanID(Integer ilanID) {
        this.ilanID = ilanID;
    }

    public String getIlanbaslik() {
        return ilanbaslik;
    }

    public void setIlanbaslik(String ilanbaslik) {
        this.ilanbaslik = ilanbaslik;
    }

    public String getIlanaciklama() {
        return ilanaciklama;
    }

    public void setIlanaciklama(String ilanaciklama) {
        this.ilanaciklama = ilanaciklama;
    }

    public Date getIlanbastarihi() {
        return ilanbastarihi;
    }

    public void setIlanbastarihi(Date ilanbastarihi) {
        this.ilanbastarihi = ilanbastarihi;
    }

    public Date getIlanbittarihi() {
        return ilanbittarihi;
    }

    public void setIlanbittarihi(Date ilanbittarihi) {
        this.ilanbittarihi = ilanbittarihi;
    }

    public Sirket getSirketID() {
        return sirketID;
    }

    public void setSirketID(Sirket sirketID) {
        this.sirketID = sirketID;
    }

    @XmlTransient
    public List<Basvuru> getBasvuruList() {
        return basvuruList;
    }

    public void setBasvuruList(List<Basvuru> basvuruList) {
        this.basvuruList = basvuruList;
    }

    @XmlTransient
    public List<Ilanteknoloji> getIlanteknolojiList() {
        return ilanteknolojiList;
    }

    public void setIlanteknolojiList(List<Ilanteknoloji> ilanteknolojiList) {
        this.ilanteknolojiList = ilanteknolojiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ilanID != null ? ilanID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ilan)) {
            return false;
        }
        Ilan other = (Ilan) object;
        if ((this.ilanID == null && other.ilanID != null) || (this.ilanID != null && !this.ilanID.equals(other.ilanID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Ilan[ ilanID=" + ilanID + " ]";
    }
    
}
