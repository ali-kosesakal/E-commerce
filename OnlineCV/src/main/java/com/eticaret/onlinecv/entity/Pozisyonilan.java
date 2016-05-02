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
 * @author esref
 */
@Entity
@Table(name = "pozisyonilan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pozisyonilan.findAll", query = "SELECT p FROM Pozisyonilan p"),
    @NamedQuery(name = "Pozisyonilan.findByPozisyonilan", query = "SELECT p FROM Pozisyonilan p WHERE p.pozisyonilan = :pozisyonilan")})
public class Pozisyonilan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pozisyonilan")
    private Integer pozisyonilan;
    @JoinColumn(name = "pozisyonID", referencedColumnName = "pozisyonID")
    @ManyToOne(optional = false)
    private Pozisyon pozisyonID;
    @JoinColumn(name = "ilanID", referencedColumnName = "ilanID")
    @ManyToOne(optional = false)
    private Ilan ilanID;

    public Pozisyonilan() {
    }

    public Pozisyonilan(Integer pozisyonilan) {
        this.pozisyonilan = pozisyonilan;
    }

    public Integer getPozisyonilan() {
        return pozisyonilan;
    }

    public void setPozisyonilan(Integer pozisyonilan) {
        this.pozisyonilan = pozisyonilan;
    }

    public Pozisyon getPozisyonID() {
        return pozisyonID;
    }

    public void setPozisyonID(Pozisyon pozisyonID) {
        this.pozisyonID = pozisyonID;
    }

    public Ilan getIlanID() {
        return ilanID;
    }

    public void setIlanID(Ilan ilanID) {
        this.ilanID = ilanID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pozisyonilan != null ? pozisyonilan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pozisyonilan)) {
            return false;
        }
        Pozisyonilan other = (Pozisyonilan) object;
        if ((this.pozisyonilan == null && other.pozisyonilan != null) || (this.pozisyonilan != null && !this.pozisyonilan.equals(other.pozisyonilan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Pozisyonilan[ pozisyonilan=" + pozisyonilan + " ]";
    }
    
}
