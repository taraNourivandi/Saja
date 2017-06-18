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

   
    @Id
    private int ID;
    private String name;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "termid")
    //private Collection<Courseprofterm> courseproftermCollection;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "termid")
    //private Collection<Average> averageCollection;

    public Term() {
    }
    
     public Term(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public int getId() {
        return ID;
    }

    public void setId(int idterm) {
        this.ID = idterm;
    }
    public void setName(String name) {
        this.name = name;
    }
}
