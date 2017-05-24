/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.dao.model;

import java.io.Serializable;
import java.util.Collection;
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
 * @author Fatemeh-pc
 */
@Entity
@Table(name = "TERMTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Term.findAll", query = "SELECT t FROM Term t")
    , @NamedQuery(name = "Term.findById", query = "SELECT t FROM Term t WHERE t.id = :id")
    , @NamedQuery(name = "Term.findByName", query = "SELECT t FROM Term t WHERE t.name = :name")})
public class Term implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "termid")
    private Collection<Courseprofterm> courseproftermCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "termid")
    private Collection<Average> averageCollection;

    public Term() {
    }

    public Term(Integer id) {
        this.id = id;
    }

    public Term(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Courseprofterm> getCourseproftermCollection() {
        return courseproftermCollection;
    }

    public void setCourseproftermCollection(Collection<Courseprofterm> courseproftermCollection) {
        this.courseproftermCollection = courseproftermCollection;
    }

    @XmlTransient
    public Collection<Average> getAverageCollection() {
        return averageCollection;
    }

    public void setAverageCollection(Collection<Average> averageCollection) {
        this.averageCollection = averageCollection;
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
        if (!(object instanceof Term)) {
            return false;
        }
        Term other = (Term) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sbu.dao.model.Term[ id=" + id + " ]";
    }
    
}
