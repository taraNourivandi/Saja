package com.sbu.dao.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

// have to be correct for my DB table

@Entity
@Table(name = "USERTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String pass;
    @Basic(optional = false)
    @Column(name = "ROLE")
    private int role;    
    @Basic(optional = false)
    @Column(name = "REFID")
    private int refId;
    
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String pass, int role, int refId) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.role = role;
        this.refId = refId;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public int getRefId() {
        return refId;
    }

    public int getRole() {
        return role;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }

    public void setRole(int role) {
        this.role = role;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.User[ id=" + id + " ]";
    }

}
