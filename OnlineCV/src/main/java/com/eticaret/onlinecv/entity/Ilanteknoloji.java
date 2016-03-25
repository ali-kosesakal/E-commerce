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
@Table(name = "ilanteknoloji")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ilanteknoloji.findAll", query = "SELECT i FROM Ilanteknoloji i"),
    @NamedQuery(name = "Ilanteknoloji.findByIdilanteknoloji", query = "SELECT i FROM Ilanteknoloji i WHERE i.idilanteknoloji = :idilanteknoloji")})
public class Ilanteknoloji implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idilanteknoloji")
    private Integer idilanteknoloji;
    @JoinColumn(name = "ilanID", referencedColumnName = "ilanID")
    @ManyToOne(optional = false)
    private Ilan ilanID;
    @JoinColumn(name = "teknolojiID", referencedColumnName = "teknolojiID")
    @ManyToOne(optional = false)
    private Teknoloji teknolojiID;

    public Ilanteknoloji() {
    }

    public Ilanteknoloji(Integer idilanteknoloji) {
        this.idilanteknoloji = idilanteknoloji;
    }

    public Integer getIdilanteknoloji() {
        return idilanteknoloji;
    }

    public void setIdilanteknoloji(Integer idilanteknoloji) {
        this.idilanteknoloji = idilanteknoloji;
    }

    public Ilan getIlanID() {
        return ilanID;
    }

    public void setIlanID(Ilan ilanID) {
        this.ilanID = ilanID;
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
        hash += (idilanteknoloji != null ? idilanteknoloji.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ilanteknoloji)) {
            return false;
        }
        Ilanteknoloji other = (Ilanteknoloji) object;
        if ((this.idilanteknoloji == null && other.idilanteknoloji != null) || (this.idilanteknoloji != null && !this.idilanteknoloji.equals(other.idilanteknoloji))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Ilanteknoloji[ idilanteknoloji=" + idilanteknoloji + " ]";
    }
    
}
