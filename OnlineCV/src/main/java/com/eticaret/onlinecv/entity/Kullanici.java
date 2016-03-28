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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author esref
 */
@Entity
@Table(name = "kullanici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanici.findAll", query = "SELECT k FROM Kullanici k"),
    @NamedQuery(name = "Kullanici.findByKullaniciID", query = "SELECT k FROM Kullanici k WHERE k.kullaniciID = :kullaniciID"),
    @NamedQuery(name = "Kullanici.findByEmail", query = "SELECT k FROM Kullanici k WHERE k.email = :email"),
    @NamedQuery(name = "Kullanici.findByParola", query = "SELECT k FROM Kullanici k WHERE k.parola = :parola"),
    @NamedQuery(name = "Kullanici.findBySongirtarihi", query = "SELECT k FROM Kullanici k WHERE k.songirtarihi = :songirtarihi")})
public class Kullanici implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kullaniciID")
    private Integer kullaniciID;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 30)
    @Column(name = "parola")
    private String parola;
    @Column(name = "songirtarihi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date songirtarihi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kullaniciID")
    private List<Basvuru> basvuruList;
    @JoinColumn(name = "ozbilgiID", referencedColumnName = "ozbilgiID")
    @ManyToOne(optional = false)
    private Kullaniciozbilgi ozbilgiID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kullaniciID")
    private List<Kullaniciteknoloji> kullaniciteknolojiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kullaniciID")
    private List<Kullanicidil> kullanicidilList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kullaniciID")
    private List<Kullaniciproje> kullaniciprojeList;

    public Kullanici() {
    }

    public Kullanici(Integer kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public Integer getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(Integer kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public Date getSongirtarihi() {
        return songirtarihi;
    }

    public void setSongirtarihi(Date songirtarihi) {
        this.songirtarihi = songirtarihi;
    }

    @XmlTransient
    public List<Basvuru> getBasvuruList() {
        return basvuruList;
    }

    public void setBasvuruList(List<Basvuru> basvuruList) {
        this.basvuruList = basvuruList;
    }

    public Kullaniciozbilgi getOzbilgiID() {
        return ozbilgiID;
    }

    public void setOzbilgiID(Kullaniciozbilgi ozbilgiID) {
        this.ozbilgiID = ozbilgiID;
    }

    @XmlTransient
    public List<Kullaniciteknoloji> getKullaniciteknolojiList() {
        return kullaniciteknolojiList;
    }

    public void setKullaniciteknolojiList(List<Kullaniciteknoloji> kullaniciteknolojiList) {
        this.kullaniciteknolojiList = kullaniciteknolojiList;
    }

    @XmlTransient
    public List<Kullanicidil> getKullanicidilList() {
        return kullanicidilList;
    }

    public void setKullanicidilList(List<Kullanicidil> kullanicidilList) {
        this.kullanicidilList = kullanicidilList;
    }

    @XmlTransient
    public List<Kullaniciproje> getKullaniciprojeList() {
        return kullaniciprojeList;
    }

    public void setKullaniciprojeList(List<Kullaniciproje> kullaniciprojeList) {
        this.kullaniciprojeList = kullaniciprojeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciID != null ? kullaniciID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanici)) {
            return false;
        }
        Kullanici other = (Kullanici) object;
        if ((this.kullaniciID == null && other.kullaniciID != null) || (this.kullaniciID != null && !this.kullaniciID.equals(other.kullaniciID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Kullanici[ kullaniciID=" + kullaniciID + " ]";
    }
    
}
