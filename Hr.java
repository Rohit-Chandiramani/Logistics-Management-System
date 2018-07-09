/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trialapp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ROHIT
 */
@Entity
@Table(name = "hr", catalog = "logistics", schema = "")
@NamedQueries({
    @NamedQuery(name = "Hr.findAll", query = "SELECT h FROM Hr h")
    , @NamedQuery(name = "Hr.findByName", query = "SELECT h FROM Hr h WHERE h.name = :name")
    , @NamedQuery(name = "Hr.findByNumber", query = "SELECT h FROM Hr h WHERE h.number = :number")
    , @NamedQuery(name = "Hr.findByUsername", query = "SELECT h FROM Hr h WHERE h.username = :username")
    , @NamedQuery(name = "Hr.findByPassword", query = "SELECT h FROM Hr h WHERE h.password = :password")
    , @NamedQuery(name = "Hr.findByType", query = "SELECT h FROM Hr h WHERE h.type = :type")})
public class Hr implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "number")
    private String number;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    public Hr() {
    }

    public Hr(String username) {
        this.username = username;
    }

    public Hr(String username, String name, String number, String password, String type) {
        this.username = username;
        this.name = name;
        this.number = number;
        this.password = password;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        String oldNumber = this.number;
        this.number = number;
        changeSupport.firePropertyChange("number", oldNumber, number);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hr)) {
            return false;
        }
        Hr other = (Hr) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trialapp.Hr[ username=" + username + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
