/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ComplainDAOLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import models.Complain;

/**
 *
 * @author skipp
 */
@Named(value = "complainBean")
@SessionScoped
public class ComplainBean implements Serializable {

    @EJB
    private ComplainDAOLocal complainDAOLocal;
    
    private int idArticle;
    private String complainType;
    private String complainAuthor;
    private String complainContent;

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getComplainType() {
        return complainType;
    }

    public void setComplainType(String complainType) {
        this.complainType = complainType;
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
    
    //getting the page with the comment
    public String getPageWithTheComplain(int idArticle) throws Exception {
        this.idArticle = idArticle;
        return "/ComplainsToChoosedArticles.xhtml";
    }

    public List<Complain> getComplainsToArticle(int idArticle) throws Exception {
        System.out.print("Comment id" + idArticle);
//       this.idArticle = idArticle;
        return this.complainDAOLocal.getComplainsForArticle(idArticle);
    }
    
    //adding the new complain for choosed article
     public String addNewComplain(int idArticle) throws Exception {
        this.complainDAOLocal.addTheComplain(idArticle, complainType, complainAuthor, complainContent);
        //System.out.println("MDEEEEEEEEEEEEEE " + idArticle + commentAuthor + commentContent);
        return "/AllArticles.xhtml";
    }

}
