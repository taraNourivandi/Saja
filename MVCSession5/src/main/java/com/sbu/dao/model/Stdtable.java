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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "STDTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stdtable.findAll", query = "SELECT s FROM Stdtable s")
    , @NamedQuery(name = "Stdtable.findById", query = "SELECT s FROM Stdtable s WHERE s.id = :id")
    , @NamedQuery(name = "Stdtable.findByName", query = "SELECT s FROM Stdtable s WHERE s.name = :name")
    , @NamedQuery(name = "Stdtable.findByGender", query = "SELECT s FROM Stdtable s WHERE s.gender = :gender")
    , @NamedQuery(name = "Stdtable.findByEmail", query = "SELECT s FROM Stdtable s WHERE s.email = :email")
    , @NamedQuery(name = "Stdtable.findByPassedunit", query = "SELECT s FROM Stdtable s WHERE s.passedunit = :passedunit")
    , @NamedQuery(name = "Stdtable.findBySection", query = "SELECT s FROM Stdtable s WHERE s.section = :section")
    , @NamedQuery(name = "Stdtable.findByDep", query = "SELECT s FROM Stdtable s WHERE s.dep = :dep")})
public class Stdtable implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENDER")
    private int gender;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PASSEDUNIT")
    private int passedunit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECTION")
    private int section;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DEP")
    private String dep;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "stdid")
    //private Collection<Stdgrade> stdgradeCollection;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "stdid")
    //private Collection<Average> averageCollection;

    @JoinColumn(name = "MAJOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Major major;

    public Stdtable() {
    }

    public Stdtable(Integer id) {
        this.id = id;
    }

    public Stdtable(Integer id, String name, int gender, String email, int passedunit, int section, String dep) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.passedunit = passedunit;
        this.section = section;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassedunit() {
        return passedunit;
    }

    public void setPassedunit(int passedunit) {
        this.passedunit = passedunit;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }
/*
    @XmlTransient
    public Collection<Stdgrade> getStdgradeCollection() {
        return stdgradeCollection;
    }

    public void setStdgradeCollection(Collection<Stdgrade> stdgradeCollection) {
        this.stdgradeCollection = stdgradeCollection;
    }
    */
/*
    @XmlTransient
    public Collection<Average> getAverageCollection() {
        return averageCollection;
    }

    public void setAverageCollection(Collection<Average> averageCollection) {
        this.averageCollection = averageCollection;
    }
    
  */
    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
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
        if (!(object instanceof Stdtable)) {
            return false;
        }
        Stdtable other = (Stdtable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sbu.dao.model.Stdtable[ id=" + id + " ]";
    }
    
}
