/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.dao.model;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatemeh-pc
 */
@Entity
@Table(name = "AVERAGETABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Average.findAll", query = "SELECT a FROM Average a")
    , @NamedQuery(name = "Average.findById", query = "SELECT a FROM Average a WHERE a.id = :id")
    , @NamedQuery(name = "Average.findByAverage", query = "SELECT a FROM Average a WHERE a.average = :average")
    , @NamedQuery(name = "Average.findByIsdirty", query = "SELECT a FROM Average a WHERE a.isdirty = :isdirty")})
public class Average implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AVERAGE")
    private double average;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISDIRTY")
    private int isdirty;
    @JoinColumn(name = "STDID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Stdtable stdid;
    @JoinColumn(name = "TERMID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Term termid;

    public Average() {
    }

    public Average(Integer id) {
        this.id = id;
    }

    public Average(Integer id, double average, int isdirty) {
        this.id = id;
        this.average = average;
        this.isdirty = isdirty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getIsdirty() {
        return isdirty;
    }

    public void setIsdirty(int isdirty) {
        this.isdirty = isdirty;
    }

    public Stdtable getStdid() {
        return stdid;
    }

    public void setStdid(Stdtable stdid) {
        this.stdid = stdid;
    }

    public Term getTermid() {
        return termid;
    }

    public void setTermid(Term termid) {
        this.termid = termid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Average)) {
            return false;
        }
        Average other = (Average) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sbu.dao.model.Average[ id=" + id + " ]";
    }
    
}
