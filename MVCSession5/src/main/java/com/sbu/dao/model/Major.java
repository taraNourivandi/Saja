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
@Table(name = "MAJORTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Major.findAll", query = "SELECT m FROM Major m")
    , @NamedQuery(name = "Major.findById", query = "SELECT m FROM Major m WHERE m.id = :id")
    , @NamedQuery(name = "Major.findByMajor", query = "SELECT m FROM Major m WHERE m.major = :major")})
public class Major implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MAJOR")
    private String major;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "allowedmajor")
    //private Collection<Allowed> allowedCollection;
    

    public Major() {
    }

    public Major(Integer id) {
        this.id = id;
    }

    public Major(Integer id, String major) {
        this.id = id;
        this.major = major;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
/*
    @XmlTransient
    public Collection<Allowed> getAllowedCollection() {
        return allowedCollection;
    }

    public void setAllowedCollection(Collection<Allowed> allowedCollection) {
        this.allowedCollection = allowedCollection;
    }
*/
   
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Major)) {
            return false;
        }
        Major other = (Major) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sbu.dao.model.Major[ id=" + id + " ]";
    }
    
}
