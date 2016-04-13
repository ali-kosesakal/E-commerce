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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "sirketproje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sirketproje.findAll", query = "SELECT s FROM Sirketproje s"),
    @NamedQuery(name = "Sirketproje.findBySirketprojeID", query = "SELECT s FROM Sirketproje s WHERE s.sirketprojeID = :sirketprojeID"),
    @NamedQuery(name = "Sirketproje.findByProjeadi", query = "SELECT s FROM Sirketproje s WHERE s.projeadi = :projeadi"),
    @NamedQuery(name = "Sirketproje.findByAciklama", query = "SELECT s FROM Sirketproje s WHERE s.aciklama = :aciklama")})
public class Sirketproje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sirketprojeID")
    private Integer sirketprojeID;
    @Size(max = 45)
    @Column(name = "projeadi")
    private String projeadi;
    @Size(max = 45)
    @Column(name = "aciklama")
    private String aciklama;
    @JoinColumn(name = "sirketID", referencedColumnName = "sirketID")
    @ManyToOne(optional = false)
    private Sirket sirketID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sirketprojeID")
    private List<Sprojetek> sprojetekList;

    public Sirketproje() {
    }

    public Sirketproje(Integer sirketprojeID) {
        this.sirketprojeID = sirketprojeID;
    }

    public Integer getSirketprojeID() {
        return sirketprojeID;
    }

    public void setSirketprojeID(Integer sirketprojeID) {
        this.sirketprojeID = sirketprojeID;
    }

    public String getProjeadi() {
        return projeadi;
    }

    public void setProjeadi(String projeadi) {
        this.projeadi = projeadi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Sirket getSirketID() {
        return sirketID;
    }

    public void setSirketID(Sirket sirketID) {
        this.sirketID = sirketID;
    }

    @XmlTransient
    public List<Sprojetek> getSprojetekList() {
        return sprojetekList;
    }

    public void setSprojetekList(List<Sprojetek> sprojetekList) {
        this.sprojetekList = sprojetekList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sirketprojeID != null ? sirketprojeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sirketproje)) {
            return false;
        }
        Sirketproje other = (Sirketproje) object;
        if ((this.sirketprojeID == null && other.sirketprojeID != null) || (this.sirketprojeID != null && !this.sirketprojeID.equals(other.sirketprojeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eticaret.onlinecv.entity.Sirketproje[ sirketprojeID=" + sirketprojeID + " ]";
    }
    
}
