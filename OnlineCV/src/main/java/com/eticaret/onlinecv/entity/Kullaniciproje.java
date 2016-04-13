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
@Table(name = "kullaniciproje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullaniciproje.findAll", query = "SELECT k FROM Kullaniciproje k"),
    @NamedQuery(name = "Kullaniciproje.findByIdkullaniciproje", query = "SELECT k FROM Kullaniciproje k WHERE k.idkullaniciproje = :idkullaniciproje")})
public class Kullaniciproje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idkullaniciproje")
    private Integer idkullaniciproje;
    @JoinColumn(name = "kullaniciID", referencedColumnName = "kullaniciID")
    @ManyToOne(optional = false)
    private Kullanici kullaniciID;
    @JoinColumn(name = "projeID", referencedColumnName = "projeID")
    @ManyToOne(optional = false)
    private Proje projeID;

    public Kullaniciproje() {
    }

    public Kullaniciproje(Integer idkullaniciproje) {
        this.idkullaniciproje = idkullaniciproje;
    }

    public Integer getIdkullaniciproje() {
        return idkullaniciproje;
    }

    public void setIdkullaniciproje(Integer idkullaniciproje) {
        this.idkullaniciproje = idkullaniciproje;
    }

    public Kullanici getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(Kullanici kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public Proje getProjeID() {
        return projeID;
    }

    public void setProjeID(Proje projeID) {
        this.projeID = projeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkullaniciproje != null ? idkullaniciproje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullaniciproje)) {
            return false;
        }
        Kullaniciproje other = (Kullaniciproje) object;
        if ((this.idkullaniciproje == null && other.idkullaniciproje != null) || (this.idkullaniciproje != null && !this.idkullaniciproje.equals(other.idkullaniciproje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Kullaniciproje[ idkullaniciproje=" + idkullaniciproje + " ]";
    }
    
}
