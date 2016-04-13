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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "projeteknoloji")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projeteknoloji.findAll", query = "SELECT p FROM Projeteknoloji p"),
    @NamedQuery(name = "Projeteknoloji.findByIdprojeteknoloji", query = "SELECT p FROM Projeteknoloji p WHERE p.idprojeteknoloji = :idprojeteknoloji")})
public class Projeteknoloji implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprojeteknoloji")
    private Integer idprojeteknoloji;
    @JoinColumn(name = "teknolojiID", referencedColumnName = "teknolojiID")
    @OneToOne(optional = false)
    private Teknoloji teknolojiID;
    @JoinColumn(name = "projeID", referencedColumnName = "projeID")
    @OneToOne(optional = false)
    private Proje projeID;

    public Projeteknoloji() {
    }

    public Projeteknoloji(Integer idprojeteknoloji) {
        this.idprojeteknoloji = idprojeteknoloji;
    }

    public Integer getIdprojeteknoloji() {
        return idprojeteknoloji;
    }

    public void setIdprojeteknoloji(Integer idprojeteknoloji) {
        this.idprojeteknoloji = idprojeteknoloji;
    }

    public Teknoloji getTeknolojiID() {
        return teknolojiID;
    }

    public void setTeknolojiID(Teknoloji teknolojiID) {
        this.teknolojiID = teknolojiID;
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
        hash += (idprojeteknoloji != null ? idprojeteknoloji.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projeteknoloji)) {
            return false;
        }
        Projeteknoloji other = (Projeteknoloji) object;
        if ((this.idprojeteknoloji == null && other.idprojeteknoloji != null) || (this.idprojeteknoloji != null && !this.idprojeteknoloji.equals(other.idprojeteknoloji))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Projeteknoloji[ idprojeteknoloji=" + idprojeteknoloji + " ]";
    }
    
}
