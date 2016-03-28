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
 * @author esref
 */
@Entity
@Table(name = "kullanicidil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanicidil.findAll", query = "SELECT k FROM Kullanicidil k"),
    @NamedQuery(name = "Kullanicidil.findByIdkullanicidil", query = "SELECT k FROM Kullanicidil k WHERE k.idkullanicidil = :idkullanicidil"),
    @NamedQuery(name = "Kullanicidil.findBySeviye", query = "SELECT k FROM Kullanicidil k WHERE k.seviye = :seviye")})
public class Kullanicidil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idkullanicidil")
    private Integer idkullanicidil;
    @Column(name = "seviye")
    private Short seviye;
    @JoinColumn(name = "kullaniciID", referencedColumnName = "kullaniciID")
    @ManyToOne(optional = false)
    private Kullanici kullaniciID;
    @JoinColumn(name = "dilID", referencedColumnName = "dilID")
    @ManyToOne(optional = false)
    private Dil dilID;

    public Kullanicidil() {
    }

    public Kullanicidil(Integer idkullanicidil) {
        this.idkullanicidil = idkullanicidil;
    }

    public Integer getIdkullanicidil() {
        return idkullanicidil;
    }

    public void setIdkullanicidil(Integer idkullanicidil) {
        this.idkullanicidil = idkullanicidil;
    }

    public Short getSeviye() {
        return seviye;
    }

    public void setSeviye(Short seviye) {
        this.seviye = seviye;
    }

    public Kullanici getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(Kullanici kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public Dil getDilID() {
        return dilID;
    }

    public void setDilID(Dil dilID) {
        this.dilID = dilID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkullanicidil != null ? idkullanicidil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanicidil)) {
            return false;
        }
        Kullanicidil other = (Kullanicidil) object;
        if ((this.idkullanicidil == null && other.idkullanicidil != null) || (this.idkullanicidil != null && !this.idkullanicidil.equals(other.idkullanicidil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Kullanicidil[ idkullanicidil=" + idkullanicidil + " ]";
    }
    
}
