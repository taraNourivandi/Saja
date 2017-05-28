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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatemeh-pc
 */
@Entity
@Table(name = "STDGRADETABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stdgrade.findAll", query = "SELECT s FROM Stdgrade s")
    , @NamedQuery(name = "Stdgrade.findById", query = "SELECT s FROM Stdgrade s WHERE s.id = :id")
    , @NamedQuery(name = "Stdgrade.findByGrade", query = "SELECT s FROM Stdgrade s WHERE s.grade = :grade")
    , @NamedQuery(name = "Stdgrade.findByGradestatus", query = "SELECT s FROM Stdgrade s WHERE s.gradestatus = :gradestatus")})
public class Stdgrade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRADE")
    private int grade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GRADESTATUS")
    private String gradestatus;
    @JoinColumn(name = "COURSEPROFTERMID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Courseprofterm courseproftermid;
    
    @JoinColumn(name = "STDID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Stdtable stdid;

    public Stdgrade() {
    }

    public Stdgrade(Integer id) {
        this.id = id;
    }

    public Stdgrade(Integer id, int grade, String gradestatus) {
        this.id = id;
        this.grade = grade;
        this.gradestatus = gradestatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getGradestatus() {
        return gradestatus;
    }

    public void setGradestatus(String gradestatus) {
        this.gradestatus = gradestatus;
    }
/*
    public Courseprofterm getCourseproftermid() {
        return courseproftermid;
    }

    public void setCourseproftermid(Courseprofterm courseproftermid) {
        this.courseproftermid = courseproftermid;
    }
*/
    public Stdtable getStdid() {
        return stdid;
    }

    public void setStdid(Stdtable stdid) {
        this.stdid = stdid;
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
        if (!(object instanceof Stdgrade)) {
            return false;
        }
        Stdgrade other = (Stdgrade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sbu.dao.model.Stdgrade[ id=" + id + " ]";
    }
    
}
