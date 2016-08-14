/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
 * @author skipp
 */
@Entity
@Table(name = "usergroups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usergroups.findAll", query = "SELECT u FROM Usergroups u"),
    @NamedQuery(name = "Usergroups.findByRole", query = "SELECT u FROM Usergroups u WHERE u.role = :role"),
    @NamedQuery(name = "Usergroups.findByIdUserGroup", query = "SELECT u FROM Usergroups u WHERE u.idUserGroup = :idUserGroup")})
public class Usergroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "role")
    private String role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUserGroup")
    private Integer idUserGroup;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User username;

    public Usergroups() {
    }

    public Usergroups(Integer idUserGroup) {
        this.idUserGroup = idUserGroup;
    }

    public Usergroups(Integer idUserGroup, String role) {
        this.idUserGroup = idUserGroup;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getIdUserGroup() {
        return idUserGroup;
    }

    public void setIdUserGroup(Integer idUserGroup) {
        this.idUserGroup = idUserGroup;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserGroup != null ? idUserGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usergroups)) {
            return false;
        }
        Usergroups other = (Usergroups) object;
        if ((this.idUserGroup == null && other.idUserGroup != null) || (this.idUserGroup != null && !this.idUserGroup.equals(other.idUserGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Usergroups[ idUserGroup=" + idUserGroup + " ]";
    }
    
}
