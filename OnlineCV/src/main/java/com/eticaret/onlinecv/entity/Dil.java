/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eticaret.onlinecv.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "dil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dil.findAll", query = "SELECT d FROM Dil d"),
    @NamedQuery(name = "Dil.findByDilID", query = "SELECT d FROM Dil d WHERE d.dilID = :dilID"),
    @NamedQuery(name = "Dil.findByDiladi", query = "SELECT d FROM Dil d WHERE d.diladi = :diladi")})
public class Dil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dilID")
    private Integer dilID;
    @Size(max = 20)
    @Column(name = "diladi")
    private String diladi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dilID")
    private List<Kullanicidil> kullanicidilList;

    public Dil() {
    }

    public Dil(Integer dilID) {
        this.dilID = dilID;
    }

    public Integer getDilID() {
        return dilID;
    }

    public void setDilID(Integer dilID) {
        this.dilID = dilID;
    }

    public String getDiladi() {
        return diladi;
    }

    public void setDiladi(String diladi) {
        this.diladi = diladi;
    }

    @XmlTransient
    public List<Kullanicidil> getKullanicidilList() {
        return kullanicidilList;
    }

    public void setKullanicidilList(List<Kullanicidil> kullanicidilList) {
        this.kullanicidilList = kullanicidilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dilID != null ? dilID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dil)) {
            return false;
        }
        Dil other = (Dil) object;
        if ((this.dilID == null && other.dilID != null) || (this.dilID != null && !this.dilID.equals(other.dilID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Dil[ dilID=" + dilID + " ]";
    }
    
}
