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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "sirketozbilgi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sirketozbilgi.findAll", query = "SELECT s FROM Sirketozbilgi s"),
    @NamedQuery(name = "Sirketozbilgi.findBySirketbilgiID", query = "SELECT s FROM Sirketozbilgi s WHERE s.sirketbilgiID = :sirketbilgiID"),
    @NamedQuery(name = "Sirketozbilgi.findBySirketadi", query = "SELECT s FROM Sirketozbilgi s WHERE s.sirketadi = :sirketadi"),
    @NamedQuery(name = "Sirketozbilgi.findBySirketadres", query = "SELECT s FROM Sirketozbilgi s WHERE s.sirketadres = :sirketadres"),
    @NamedQuery(name = "Sirketozbilgi.findBySirkettel", query = "SELECT s FROM Sirketozbilgi s WHERE s.sirkettel = :sirkettel"),
    @NamedQuery(name = "Sirketozbilgi.findByKurultarihi", query = "SELECT s FROM Sirketozbilgi s WHERE s.kurultarihi = :kurultarihi"),
    @NamedQuery(name = "Sirketozbilgi.findBySirketaciklama", query = "SELECT s FROM Sirketozbilgi s WHERE s.sirketaciklama = :sirketaciklama"),
    @NamedQuery(name = "Sirketozbilgi.findByWebadres", query = "SELECT s FROM Sirketozbilgi s WHERE s.webadres = :webadres"),
    @NamedQuery(name = "Sirketozbilgi.findByLogo", query = "SELECT s FROM Sirketozbilgi s WHERE s.logo = :logo"),
    @NamedQuery(name = "Sirketozbilgi.findByAcikpozisyon", query = "SELECT s FROM Sirketozbilgi s WHERE s.acikpozisyon = :acikpozisyon")})
public class Sirketozbilgi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sirketbilgiID")
    private Integer sirketbilgiID;
    @Size(max = 45)
    @Column(name = "sirketadi")
    private String sirketadi;
    @Size(max = 45)
    @Column(name = "sirketadres")
    private String sirketadres;
    @Size(max = 15)
    @Column(name = "sirkettel")
    private String sirkettel;
    @Column(name = "kurultarihi")
    @Temporal(TemporalType.DATE)
    private Date kurultarihi;
    @Size(max = 500)
    @Column(name = "sirketaciklama")
    private String sirketaciklama;
    @Size(max = 45)
    @Column(name = "webadres")
    private String webadres;
    @Size(max = 45)
    @Column(name = "logo")
    private String logo;
    @Size(max = 45)
    @Column(name = "acikpozisyon")
    private String acikpozisyon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sirketbilgiID")
    private List<Sirket> sirketList;

    public Sirketozbilgi() {
    }

    public Sirketozbilgi(Integer sirketbilgiID) {
        this.sirketbilgiID = sirketbilgiID;
    }

    public Integer getSirketbilgiID() {
        return sirketbilgiID;
    }

    public void setSirketbilgiID(Integer sirketbilgiID) {
        this.sirketbilgiID = sirketbilgiID;
    }

    public String getSirketadi() {
        return sirketadi;
    }

    public void setSirketadi(String sirketadi) {
        this.sirketadi = sirketadi;
    }

    public String getSirketadres() {
        return sirketadres;
    }

    public void setSirketadres(String sirketadres) {
        this.sirketadres = sirketadres;
    }

    public String getSirkettel() {
        return sirkettel;
    }

    public void setSirkettel(String sirkettel) {
        this.sirkettel = sirkettel;
    }

    public Date getKurultarihi() {
        return kurultarihi;
    }

    public void setKurultarihi(Date kurultarihi) {
        this.kurultarihi = kurultarihi;
    }

    public String getSirketaciklama() {
        return sirketaciklama;
    }

    public void setSirketaciklama(String sirketaciklama) {
        this.sirketaciklama = sirketaciklama;
    }

    public String getWebadres() {
        return webadres;
    }

    public void setWebadres(String webadres) {
        this.webadres = webadres;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAcikpozisyon() {
        return acikpozisyon;
    }

    public void setAcikpozisyon(String acikpozisyon) {
        this.acikpozisyon = acikpozisyon;
    }

    @XmlTransient
    public List<Sirket> getSirketList() {
        return sirketList;
    }

    public void setSirketList(List<Sirket> sirketList) {
        this.sirketList = sirketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sirketbilgiID != null ? sirketbilgiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sirketozbilgi)) {
            return false;
        }
        Sirketozbilgi other = (Sirketozbilgi) object;
        if ((this.sirketbilgiID == null && other.sirketbilgiID != null) || (this.sirketbilgiID != null && !this.sirketbilgiID.equals(other.sirketbilgiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Sirketozbilgi[ sirketbilgiID=" + sirketbilgiID + " ]";
    }
    
}
