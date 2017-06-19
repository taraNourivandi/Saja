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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "PROFTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prof.findAll", query = "SELECT p FROM Prof p")
    , @NamedQuery(name = "Prof.findById", query = "SELECT p FROM Prof p WHERE p.id = :id")
    , @NamedQuery(name = "Prof.findByName", query = "SELECT p FROM Prof p WHERE p.name = :name")
    , @NamedQuery(name = "Prof.findByEmail", query = "SELECT p FROM Prof p WHERE p.email = :email")
    , @NamedQuery(name = "Prof.findByDep", query = "SELECT p FROM Prof p WHERE p.dep = :dep")})
public class Prof implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DEP")
    private String dep;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profid")
    private Collection<Courseprofterm> courseproftermCollection;

    public void setCourseproftermCollection(Collection<Courseprofterm> courseproftermCollection) {
        this.courseproftermCollection = courseproftermCollection;
    }

    public Collection<Courseprofterm> getCourseproftermCollection() {
        return courseproftermCollection;
    }
    

    public Prof() {
    }

    public Prof(Integer id) {
        this.id = id;
    }

    public Prof(Integer id, String name, String email, String dep) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dep = dep;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
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
        if (!(object instanceof Prof)) {
            return false;
        }
        Prof other = (Prof) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sbu.dao.model.Prof[ id=" + id + " ]";
    }
    
}
