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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "sirketpozisyon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sirketpozisyon.findAll", query = "SELECT s FROM Sirketpozisyon s"),
    @NamedQuery(name = "Sirketpozisyon.findByIdsirketpozisyon", query = "SELECT s FROM Sirketpozisyon s WHERE s.idsirketpozisyon = :idsirketpozisyon")})
public class Sirketpozisyon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsirketpozisyon")
    private Integer idsirketpozisyon;
    @JoinColumn(name = "sirketID", referencedColumnName = "sirketID")
    @ManyToOne(optional = false)
    private Sirket sirketID;
    @JoinColumn(name = "pozisyonID", referencedColumnName = "pozisyonID")
    @ManyToOne(optional = false)
    private Pozisyon pozisyonID;

    public Sirketpozisyon() {
    }

    public Sirketpozisyon(Integer idsirketpozisyon) {
        this.idsirketpozisyon = idsirketpozisyon;
    }

    public Integer getIdsirketpozisyon() {
        return idsirketpozisyon;
    }

    public void setIdsirketpozisyon(Integer idsirketpozisyon) {
        this.idsirketpozisyon = idsirketpozisyon;
    }

    public Sirket getSirketID() {
        return sirketID;
    }

    public void setSirketID(Sirket sirketID) {
        this.sirketID = sirketID;
    }

    public Pozisyon getPozisyonID() {
        return pozisyonID;
    }

    public void setPozisyonID(Pozisyon pozisyonID) {
        this.pozisyonID = pozisyonID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsirketpozisyon != null ? idsirketpozisyon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sirketpozisyon)) {
            return false;
        }
        Sirketpozisyon other = (Sirketpozisyon) object;
        if ((this.idsirketpozisyon == null && other.idsirketpozisyon != null) || (this.idsirketpozisyon != null && !this.idsirketpozisyon.equals(other.idsirketpozisyon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Sirketpozisyon[ idsirketpozisyon=" + idsirketpozisyon + " ]";
    }
    
}
