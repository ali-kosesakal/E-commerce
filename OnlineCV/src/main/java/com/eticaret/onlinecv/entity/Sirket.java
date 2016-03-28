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
@Table(name = "sirket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sirket.findAll", query = "SELECT s FROM Sirket s"),
    @NamedQuery(name = "Sirket.findBySirketID", query = "SELECT s FROM Sirket s WHERE s.sirketID = :sirketID"),
    @NamedQuery(name = "Sirket.findByEmail", query = "SELECT s FROM Sirket s WHERE s.email = :email"),
    @NamedQuery(name = "Sirket.findByParola", query = "SELECT s FROM Sirket s WHERE s.parola = :parola"),
    @NamedQuery(name = "Sirket.findBySongirtarihi", query = "SELECT s FROM Sirket s WHERE s.songirtarihi = :songirtarihi")})
public class Sirket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sirketID")
    private Integer sirketID;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 30)
    @Column(name = "parola")
    private String parola;
    @Column(name = "songirtarihi")
    @Temporal(TemporalType.DATE)
    private Date songirtarihi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sirketID")
    private List<Ilan> ilanList;
    @JoinColumn(name = "sirketbilgiID", referencedColumnName = "sirketbilgiID")
    @ManyToOne(optional = false)
    private Sirketozbilgi sirketbilgiID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sirketID")
    private List<Sirketteknoloji> sirketteknolojiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sirketID")
    private List<Sirketproje> sirketprojeList;

    public Sirket() {
    }

    public Sirket(Integer sirketID) {
        this.sirketID = sirketID;
    }

    public Integer getSirketID() {
        return sirketID;
    }

    public void setSirketID(Integer sirketID) {
        this.sirketID = sirketID;
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
    public List<Ilan> getIlanList() {
        return ilanList;
    }

    public void setIlanList(List<Ilan> ilanList) {
        this.ilanList = ilanList;
    }

    public Sirketozbilgi getSirketbilgiID() {
        return sirketbilgiID;
    }

    public void setSirketbilgiID(Sirketozbilgi sirketbilgiID) {
        this.sirketbilgiID = sirketbilgiID;
    }

    @XmlTransient
    public List<Sirketteknoloji> getSirketteknolojiList() {
        return sirketteknolojiList;
    }

    public void setSirketteknolojiList(List<Sirketteknoloji> sirketteknolojiList) {
        this.sirketteknolojiList = sirketteknolojiList;
    }

    @XmlTransient
    public List<Sirketproje> getSirketprojeList() {
        return sirketprojeList;
    }

    public void setSirketprojeList(List<Sirketproje> sirketprojeList) {
        this.sirketprojeList = sirketprojeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sirketID != null ? sirketID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sirket)) {
            return false;
        }
        Sirket other = (Sirket) object;
        if ((this.sirketID == null && other.sirketID != null) || (this.sirketID != null && !this.sirketID.equals(other.sirketID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Sirket[ sirketID=" + sirketID + " ]";
    }
    
}
