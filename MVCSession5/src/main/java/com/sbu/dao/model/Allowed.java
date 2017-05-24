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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatemeh-pc
 */
@Entity
@Table(name = "ALLOWEDTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Allowed.findAll", query = "SELECT a FROM Allowed a")
    , @NamedQuery(name = "Allowed.findById", query = "SELECT a FROM Allowed a WHERE a.id = :id")
    , @NamedQuery(name = "Allowed.findByAllowedentry", query = "SELECT a FROM Allowed a WHERE a.allowedentry = :allowedentry")
    , @NamedQuery(name = "Allowed.findByAllowedmajor", query = "SELECT a FROM Allowed a WHERE a.allowedmajor = :allowedmajor")})
public class Allowed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ALLOWEDENTRY")
    private String allowedentry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ALLOWEDMAJOR")
    private String allowedmajor;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Course course;

    public Allowed() {
    }

    public Allowed(Integer id) {
        this.id = id;
    }

    public Allowed(Integer id, String allowedentry, String allowedmajor) {
        this.id = id;
        this.allowedentry = allowedentry;
        this.allowedmajor = allowedmajor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAllowedentry() {
        return allowedentry;
    }

    public void setAllowedentry(String allowedentry) {
        this.allowedentry = allowedentry;
    }

    public String getAllowedmajor() {
        return allowedmajor;
    }

    public void setAllowedmajor(String allowedmajor) {
        this.allowedmajor = allowedmajor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
        if (!(object instanceof Allowed)) {
            return false;
        }
        Allowed other = (Allowed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sbu.dao.model.Allowed[ id=" + id + " ]";
    }
    
}
