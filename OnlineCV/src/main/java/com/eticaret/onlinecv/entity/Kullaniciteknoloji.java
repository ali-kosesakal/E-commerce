/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "kullaniciteknoloji")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullaniciteknoloji.findAll", query = "SELECT k FROM Kullaniciteknoloji k"),
    @NamedQuery(name = "Kullaniciteknoloji.findByIdkullaniciteknoloji", query = "SELECT k FROM Kullaniciteknoloji k WHERE k.idkullaniciteknoloji = :idkullaniciteknoloji")})
public class Kullaniciteknoloji implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idkullaniciteknoloji")
    private Integer idkullaniciteknoloji;
    @JoinColumn(name = "kullaniciID", referencedColumnName = "kullaniciID")
    @ManyToOne(optional = false)
    private Kullanici kullaniciID;
    @JoinColumn(name = "teknolojiID", referencedColumnName = "teknolojiID")
    @ManyToOne(optional = false)
    private Teknoloji teknolojiID;

    public Kullaniciteknoloji() {
    }

    public Kullaniciteknoloji(Integer idkullaniciteknoloji) {
        this.idkullaniciteknoloji = idkullaniciteknoloji;
    }

    public Integer getIdkullaniciteknoloji() {
        return idkullaniciteknoloji;
    }

    public void setIdkullaniciteknoloji(Integer idkullaniciteknoloji) {
        this.idkullaniciteknoloji = idkullaniciteknoloji;
    }

    public Kullanici getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(Kullanici kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public Teknoloji getTeknolojiID() {
        return teknolojiID;
    }

    public void setTeknolojiID(Teknoloji teknolojiID) {
        this.teknolojiID = teknolojiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkullaniciteknoloji != null ? idkullaniciteknoloji.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullaniciteknoloji)) {
            return false;
        }
        Kullaniciteknoloji other = (Kullaniciteknoloji) object;
        if ((this.idkullaniciteknoloji == null && other.idkullaniciteknoloji != null) || (this.idkullaniciteknoloji != null && !this.idkullaniciteknoloji.equals(other.idkullaniciteknoloji))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Kullaniciteknoloji[ idkullaniciteknoloji=" + idkullaniciteknoloji + " ]";
    }
    
}
