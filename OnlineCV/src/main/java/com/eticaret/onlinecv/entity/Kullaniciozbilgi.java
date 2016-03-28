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
 * @author esref
 */
@Entity
@Table(name = "kullaniciozbilgi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullaniciozbilgi.findAll", query = "SELECT k FROM Kullaniciozbilgi k"),
    @NamedQuery(name = "Kullaniciozbilgi.findByOzbilgiID", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.ozbilgiID = :ozbilgiID"),
    @NamedQuery(name = "Kullaniciozbilgi.findByAd", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.ad = :ad"),
    @NamedQuery(name = "Kullaniciozbilgi.findBySoyad", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.soyad = :soyad"),
    @NamedQuery(name = "Kullaniciozbilgi.findByAdres", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.adres = :adres"),
    @NamedQuery(name = "Kullaniciozbilgi.findByTel", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.tel = :tel"),
    @NamedQuery(name = "Kullaniciozbilgi.findByDtarihi", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.dtarihi = :dtarihi"),
    @NamedQuery(name = "Kullaniciozbilgi.findByUnibastarihi", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.unibastarihi = :unibastarihi"),
    @NamedQuery(name = "Kullaniciozbilgi.findByUnibittarihi", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.unibittarihi = :unibittarihi"),
    @NamedQuery(name = "Kullaniciozbilgi.findByAgno", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.agno = :agno"),
    @NamedQuery(name = "Kullaniciozbilgi.findByLise", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.lise = :lise"),
    @NamedQuery(name = "Kullaniciozbilgi.findByLisebastarihi", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.lisebastarihi = :lisebastarihi"),
    @NamedQuery(name = "Kullaniciozbilgi.findByLisebittarihi", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.lisebittarihi = :lisebittarihi"),
    @NamedQuery(name = "Kullaniciozbilgi.findByAciklama", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.aciklama = :aciklama"),
    @NamedQuery(name = "Kullaniciozbilgi.findByProfilresim", query = "SELECT k FROM Kullaniciozbilgi k WHERE k.profilresim = :profilresim")})
public class Kullaniciozbilgi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ozbilgiID")
    private Integer ozbilgiID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ad")
    private String ad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "soyad")
    private String soyad;
    @Size(max = 200)
    @Column(name = "adres")
    private String adres;
    @Size(max = 10)
    @Column(name = "tel")
    private String tel;
    @Column(name = "dtarihi")
    @Temporal(TemporalType.DATE)
    private Date dtarihi;
    @Column(name = "unibastarihi")
    @Temporal(TemporalType.DATE)
    private Date unibastarihi;
    @Column(name = "unibittarihi")
    @Temporal(TemporalType.DATE)
    private Date unibittarihi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "agno")
    private Double agno;
    @Size(max = 100)
    @Column(name = "lise")
    private String lise;
    @Column(name = "lisebastarihi")
    @Temporal(TemporalType.DATE)
    private Date lisebastarihi;
    @Column(name = "lisebittarihi")
    @Temporal(TemporalType.DATE)
    private Date lisebittarihi;
    @Size(max = 300)
    @Column(name = "aciklama")
    private String aciklama;
    @Size(max = 100)
    @Column(name = "profilresim")
    private String profilresim;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ozbilgiID")
    private List<Kullanici> kullaniciList;
    @JoinColumn(name = "universiteID", referencedColumnName = "universiteID")
    @ManyToOne
    private Universite universiteID;

    public Kullaniciozbilgi() {
    }

    public Kullaniciozbilgi(Integer ozbilgiID) {
        this.ozbilgiID = ozbilgiID;
    }

    public Kullaniciozbilgi(Integer ozbilgiID, String ad, String soyad) {
        this.ozbilgiID = ozbilgiID;
        this.ad = ad;
        this.soyad = soyad;
    }

    public Integer getOzbilgiID() {
        return ozbilgiID;
    }

    public void setOzbilgiID(Integer ozbilgiID) {
        this.ozbilgiID = ozbilgiID;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDtarihi() {
        return dtarihi;
    }

    public void setDtarihi(Date dtarihi) {
        this.dtarihi = dtarihi;
    }

    public Date getUnibastarihi() {
        return unibastarihi;
    }

    public void setUnibastarihi(Date unibastarihi) {
        this.unibastarihi = unibastarihi;
    }

    public Date getUnibittarihi() {
        return unibittarihi;
    }

    public void setUnibittarihi(Date unibittarihi) {
        this.unibittarihi = unibittarihi;
    }

    public Double getAgno() {
        return agno;
    }

    public void setAgno(Double agno) {
        this.agno = agno;
    }

    public String getLise() {
        return lise;
    }

    public void setLise(String lise) {
        this.lise = lise;
    }

    public Date getLisebastarihi() {
        return lisebastarihi;
    }

    public void setLisebastarihi(Date lisebastarihi) {
        this.lisebastarihi = lisebastarihi;
    }

    public Date getLisebittarihi() {
        return lisebittarihi;
    }

    public void setLisebittarihi(Date lisebittarihi) {
        this.lisebittarihi = lisebittarihi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getProfilresim() {
        return profilresim;
    }

    public void setProfilresim(String profilresim) {
        this.profilresim = profilresim;
    }

    @XmlTransient
    public List<Kullanici> getKullaniciList() {
        return kullaniciList;
    }

    public void setKullaniciList(List<Kullanici> kullaniciList) {
        this.kullaniciList = kullaniciList;
    }

    public Universite getUniversiteID() {
        return universiteID;
    }

    public void setUniversiteID(Universite universiteID) {
        this.universiteID = universiteID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ozbilgiID != null ? ozbilgiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullaniciozbilgi)) {
            return false;
        }
        Kullaniciozbilgi other = (Kullaniciozbilgi) object;
        if ((this.ozbilgiID == null && other.ozbilgiID != null) || (this.ozbilgiID != null && !this.ozbilgiID.equals(other.ozbilgiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Kullaniciozbilgi[ ozbilgiID=" + ozbilgiID + " ]";
    }
    
}
