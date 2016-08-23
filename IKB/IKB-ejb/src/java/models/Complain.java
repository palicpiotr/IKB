/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author skipp
 */
@Entity
@Table(name = "complain")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complain.findAll", query = "SELECT c FROM Complain c"),
    @NamedQuery(name = "Complain.findByIdComplain", query = "SELECT c FROM Complain c WHERE c.idComplain = :idComplain"),
    @NamedQuery(name = "Complain.findByType", query = "SELECT c FROM Complain c WHERE c.type = :type"),
    @NamedQuery(name = "Complain.findByComplainAuthor", query = "SELECT c FROM Complain c WHERE c.complainAuthor = :complainAuthor"),
    @NamedQuery(name = "Complain.findByAddingDate", query = "SELECT c FROM Complain c WHERE c.addingDate = :addingDate")})
public class Complain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComplain")
    private Integer idComplain;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "complainAuthor")
    private String complainAuthor;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "complainContent")
    private String complainContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "addingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addingDate;
    @JoinColumn(name = "articleID", referencedColumnName = "idArticle")
    @ManyToOne(optional = false)
    private Article articleID;

    public Complain() {
    }

    public Complain(Integer idComplain) {
        this.idComplain = idComplain;
    }

    public Complain(Integer idComplain, String type, String complainAuthor, String complainContent, Date addingDate) {
        this.idComplain = idComplain;
        this.type = type;
        this.complainAuthor = complainAuthor;
        this.complainContent = complainContent;
        this.addingDate = addingDate;
    }

    public Integer getIdComplain() {
        return idComplain;
    }

    public void setIdComplain(Integer idComplain) {
        this.idComplain = idComplain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComplainAuthor() {
        return complainAuthor;
    }

    public void setComplainAuthor(String complainAuthor) {
        this.complainAuthor = complainAuthor;
    }

    public String getComplainContent() {
        return complainContent;
    }

    public void setComplainContent(String complainContent) {
        this.complainContent = complainContent;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    public Article getArticleID() {
        return articleID;
    }

    public void setArticleID(Article articleID) {
        this.articleID = articleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComplain != null ? idComplain.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complain)) {
            return false;
        }
        Complain other = (Complain) object;
        if ((this.idComplain == null && other.idComplain != null) || (this.idComplain != null && !this.idComplain.equals(other.idComplain))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Complain[ idComplain=" + idComplain + " ]";
    }
    
}
