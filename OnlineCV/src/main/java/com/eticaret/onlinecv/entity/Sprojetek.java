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
@Table(name = "sprojetek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprojetek.findAll", query = "SELECT s FROM Sprojetek s"),
    @NamedQuery(name = "Sprojetek.findByIdsprojetek", query = "SELECT s FROM Sprojetek s WHERE s.idsprojetek = :idsprojetek")})
public class Sprojetek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsprojetek")
    private Integer idsprojetek;
    @JoinColumn(name = "sirketprojeID", referencedColumnName = "sirketprojeID")
    @ManyToOne(optional = false)
    private Sirketproje sirketprojeID;
    @JoinColumn(name = "teknolojiID", referencedColumnName = "teknolojiID")
    @ManyToOne(optional = false)
    private Teknoloji teknolojiID;

    public Sprojetek() {
    }

    public Sprojetek(Integer idsprojetek) {
        this.idsprojetek = idsprojetek;
    }

    public Integer getIdsprojetek() {
        return idsprojetek;
    }

    public void setIdsprojetek(Integer idsprojetek) {
        this.idsprojetek = idsprojetek;
    }

    public Sirketproje getSirketprojeID() {
        return sirketprojeID;
    }

    public void setSirketprojeID(Sirketproje sirketprojeID) {
        this.sirketprojeID = sirketprojeID;
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
        hash += (idsprojetek != null ? idsprojetek.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sprojetek)) {
            return false;
        }
        Sprojetek other = (Sprojetek) object;
        if ((this.idsprojetek == null && other.idsprojetek != null) || (this.idsprojetek != null && !this.idsprojetek.equals(other.idsprojetek))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Sprojetek[ idsprojetek=" + idsprojetek + " ]";
    }
    
}
