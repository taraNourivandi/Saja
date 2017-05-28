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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
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
    
    @TableGenerator(name = "course_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "course_gen")
    private int idcourse;
    private String name;
    private int units;
    private int labtheorytype;
    private int coursetype;
    private int coursegender;
    private int coursesection;
    private int preCourseID;
    
    
    @ManyToOne
    @JoinColumn(name = "TERM", referencedColumnName = "ID")
    private Term term;
    
    @ManyToOne
    @JoinColumn(name = "MAJOR", referencedColumnName = "ID")
    private Major major;

    public void setTerm(Term term) {
        this.term = term;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Term getTerm() {
        return term;
    }

    public Major getMajor() {
        return major;
    }

    public Course() {
    }

    public Course(String name, int units, int labtheorytype, int coursetype, int coursegender, int coursesection, int preCourseID) {
        this.idcourse = idcourse;
        this.name = name;
        this.units = units;
        this.labtheorytype = labtheorytype;
        this.coursetype = coursetype;
        this.coursegender = coursegender;
        this.coursesection = coursesection;
        this.preCourseID = preCourseID;
    }
    
    

    public void setId(int idcourse) {
        this.idcourse = idcourse;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setLabtheorytype(int labtheorytype) {
        this.labtheorytype = labtheorytype;
    }

    public void setCoursetype(int coursetype) {
        this.coursetype = coursetype;
    }

    public void setCoursegender(int coursegender) {
        this.coursegender = coursegender;
    }

    public void setCoursesection(int coursesection) {
        this.coursesection = coursesection;
    }

    public void setPreCourseID(int preCourseID) {
        this.preCourseID = preCourseID;
    }

    public int getId() {
        return idcourse;
    }

    public String getName() {
        return name;
    }

    public int getUnits() {
        return units;
    }

    public int getLabtheorytype() {
        return labtheorytype;
    }

    public int getCoursetype() {
        return coursetype;
    }

    public int getCoursegender() {
        return coursegender;
    }

    public int getCoursesection() {
        return coursesection;
    }

    public int getPreCourseID() {
        return preCourseID;
    }
    
    
}
