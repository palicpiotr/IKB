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
@Table(name = "comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
    @NamedQuery(name = "Comments.findByIdComment", query = "SELECT c FROM Comments c WHERE c.idComment = :idComment"),
    @NamedQuery(name = "Comments.findByAddingDateComment", query = "SELECT c FROM Comments c WHERE c.addingDateComment = :addingDateComment"),
    @NamedQuery(name = "Comments.findByCommentAuthor", query = "SELECT c FROM Comments c WHERE c.commentAuthor = :commentAuthor")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComment")
    private Integer idComment;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "commentContent")
    private String commentContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "addingDateComment")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addingDateComment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "commentAuthor")
    private String commentAuthor;
    @JoinColumn(name = "idArticle", referencedColumnName = "idArticle")
    @ManyToOne(optional = false)
    private Article idArticle;

    public Comments() {
    }

    public Comments(Integer idComment) {
        this.idComment = idComment;
    }

    public Comments(Integer idComment, String commentContent, Date addingDateComment, String commentAuthor) {
        this.idComment = idComment;
        this.commentContent = commentContent;
        this.addingDateComment = addingDateComment;
        this.commentAuthor = commentAuthor;
    }

    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getAddingDateComment() {
        return addingDateComment;
    }

    public void setAddingDateComment(Date addingDateComment) {
        this.addingDateComment = addingDateComment;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComment != null ? idComment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.idComment == null && other.idComment != null) || (this.idComment != null && !this.idComment.equals(other.idComment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Comments[ idComment=" + idComment + " ]";
    }
    
}
