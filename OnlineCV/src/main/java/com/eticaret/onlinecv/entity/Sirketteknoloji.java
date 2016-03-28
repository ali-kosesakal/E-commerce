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
@Table(name = "sirketteknoloji")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sirketteknoloji.findAll", query = "SELECT s FROM Sirketteknoloji s"),
    @NamedQuery(name = "Sirketteknoloji.findByIdsirketteknoloji", query = "SELECT s FROM Sirketteknoloji s WHERE s.idsirketteknoloji = :idsirketteknoloji")})
public class Sirketteknoloji implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsirketteknoloji")
    private Integer idsirketteknoloji;
    @JoinColumn(name = "teknolojiID", referencedColumnName = "teknolojiID")
    @ManyToOne(optional = false)
    private Teknoloji teknolojiID;
    @JoinColumn(name = "sirketID", referencedColumnName = "sirketID")
    @ManyToOne(optional = false)
    private Sirket sirketID;

    public Sirketteknoloji() {
    }

    public Sirketteknoloji(Integer idsirketteknoloji) {
        this.idsirketteknoloji = idsirketteknoloji;
    }

    public Integer getIdsirketteknoloji() {
        return idsirketteknoloji;
    }

    public void setIdsirketteknoloji(Integer idsirketteknoloji) {
        this.idsirketteknoloji = idsirketteknoloji;
    }

    public Teknoloji getTeknolojiID() {
        return teknolojiID;
    }

    public void setTeknolojiID(Teknoloji teknolojiID) {
        this.teknolojiID = teknolojiID;
    }

    public Sirket getSirketID() {
        return sirketID;
    }

    public void setSirketID(Sirket sirketID) {
        this.sirketID = sirketID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsirketteknoloji != null ? idsirketteknoloji.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sirketteknoloji)) {
            return false;
        }
        Sirketteknoloji other = (Sirketteknoloji) object;
        if ((this.idsirketteknoloji == null && other.idsirketteknoloji != null) || (this.idsirketteknoloji != null && !this.idsirketteknoloji.equals(other.idsirketteknoloji))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Sirketteknoloji[ idsirketteknoloji=" + idsirketteknoloji + " ]";
    }
    
}
