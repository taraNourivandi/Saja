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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "COURSETABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id")
    , @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name")
    , @NamedQuery(name = "Course.findByUnits", query = "SELECT c FROM Course c WHERE c.units = :units")
    , @NamedQuery(name = "Course.findByLabtheorytype", query = "SELECT c FROM Course c WHERE c.labtheorytype = :labtheorytype")
    , @NamedQuery(name = "Course.findByCoursetype", query = "SELECT c FROM Course c WHERE c.coursetype = :coursetype")
    , @NamedQuery(name = "Course.findByCoursegender", query = "SELECT c FROM Course c WHERE c.coursegender = :coursegender")
    , @NamedQuery(name = "Course.findByCoursesection", query = "SELECT c FROM Course c WHERE c.coursesection = :coursesection")})
public class Course implements Serializable {

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
    @Column(name = "UNITS")
    private int units;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LABTHEORYTYPE")
    private int labtheorytype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSETYPE")
    private int coursetype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSEGENDER")
    private int coursegender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSESECTION")
    private int coursesection;
    @JoinTable(name = "PRECOURSETABLE", joinColumns = {
        @JoinColumn(name = "COURSEID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PRECOURSEID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Course> courseCollection;
    @ManyToMany(mappedBy = "courseCollection")
    private Collection<Course> courseCollection1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "course")
    private Allowed allowed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseid")
    private Collection<Courseprofterm> courseproftermCollection;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course(Integer id, String name, int units, int labtheorytype, int coursetype, int coursegender, int coursesection) {
        this.id = id;
        this.name = name;
        this.units = units;
        this.labtheorytype = labtheorytype;
        this.coursetype = coursetype;
        this.coursegender = coursegender;
        this.coursesection = coursesection;
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

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getLabtheorytype() {
        return labtheorytype;
    }

    public void setLabtheorytype(int labtheorytype) {
        this.labtheorytype = labtheorytype;
    }

    public int getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(int coursetype) {
        this.coursetype = coursetype;
    }

    public int getCoursegender() {
        return coursegender;
    }

    public void setCoursegender(int coursegender) {
        this.coursegender = coursegender;
    }

    public int getCoursesection() {
        return coursesection;
    }

    public void setCoursesection(int coursesection) {
        this.coursesection = coursesection;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection1() {
        return courseCollection1;
    }

    public void setCourseCollection1(Collection<Course> courseCollection1) {
        this.courseCollection1 = courseCollection1;
    }

    public Allowed getAllowed() {
        return allowed;
    }

    public void setAllowed(Allowed allowed) {
        this.allowed = allowed;
    }

    @XmlTransient
    public Collection<Courseprofterm> getCourseproftermCollection() {
        return courseproftermCollection;
    }

    public void setCourseproftermCollection(Collection<Courseprofterm> courseproftermCollection) {
        this.courseproftermCollection = courseproftermCollection;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sbu.dao.model.Course[ id=" + id + " ]";
    }
    
}
