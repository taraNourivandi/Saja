/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.dao.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fatemeh-pc
 */
@Entity
@Table(name = "COURSEPROFTERMTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courseprofterm.findAll", query = "SELECT c FROM Courseprofterm c")
    , @NamedQuery(name = "Courseprofterm.findById", query = "SELECT c FROM Courseprofterm c WHERE c.id = :id")
    , @NamedQuery(name = "Courseprofterm.findByDatetime", query = "SELECT c FROM Courseprofterm c WHERE c.datetime = :datetime")
    , @NamedQuery(name = "Courseprofterm.findByExamdate", query = "SELECT c FROM Courseprofterm c WHERE c.examdate = :examdate")
    , @NamedQuery(name = "Courseprofterm.findByCapasity", query = "SELECT c FROM Courseprofterm c WHERE c.capasity = :capasity")})
public class Courseprofterm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DATETIME")
    private String datetime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXAMDATE")
    private String examdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPASITY")
    private int capasity;
    
    @JoinColumn(name = "COURSEID", referencedColumnName = "IDCOURSE")
    @ManyToOne(optional = false)
    private Course courseid;
    
    @JoinColumn(name = "PROFID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Prof profid;

    public void setStdgradeCollection(Collection<Stdgrade> stdgradeCollection) {
        this.stdgradeCollection = stdgradeCollection;
    }

    public Collection<Stdgrade> getStdgradeCollection() {
        return stdgradeCollection;
    }
    @JoinColumn(name = "TERMID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Term termid;
    //delete
    @OneToMany(mappedBy = "courseproftermid")
    private Collection<Stdgrade> stdgradeCollection;

    public Courseprofterm() {
    }

    public Courseprofterm(Integer id) {
        this.id = id;
    }

    public Courseprofterm(Integer id, String datetime, String examdate, int capasity) {
        this.id = id;
        this.datetime = datetime;
        this.examdate = examdate;
        this.capasity = capasity;
    }

    //Tara
    public Courseprofterm(String date,String exam, int capacity,Course course,Prof prof,Term term){
        this.datetime=date;
        this.examdate=exam;
        this.capasity=capacity;
        this.courseid=course;
        this.profid=prof;
        this.termid=term;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getExamdate() {
        return examdate;
    }

    public void setExamdate(String examdate) {
        this.examdate = examdate;
    }

    public int getCapasity() {
        return capasity;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
    }

    public Prof getProfid() {
        return profid;
    }

    public void setProfid(Prof profid) {
        this.profid = profid;
    }

    public Term getTermid() {
        return termid;
    }

    public void setTermid(Term termid) {
        this.termid = termid;
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
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courseprofterm)) {
            return false;
        }
        Courseprofterm other = (Courseprofterm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sbu.dao.model.Courseprofterm[ id=" + id + " ]";
    }
    
}
