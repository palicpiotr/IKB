/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ArticleDAOLocal;
import dao.PostDAOLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import models.Article;
import models.Articletype;

/**
 *
 * @author skipp
 */
@Named(value = "postBean")
@SessionScoped
public class PostBean implements Serializable {

    @EJB
    PostDAOLocal postDAOLocal;

    @EJB
    private ArticleDAOLocal articleDAOLocal;

    private String articleTypeName;
    private int idArticletype;

    private int localId;

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public int getIdArticletype() {
        return idArticletype;
    }

    public void setIdArticletype(int idArticletype) {
        this.idArticletype = idArticletype;
    }

    //this method is used to select * categories
    public List<Articletype> getAllArticleTypes() throws Exception {
        System.out.println("LOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOH");
        return this.postDAOLocal.getAllArticleTypes();
    }

    //this method is used to adding the new cateory of artices
    public String addNewArticleType() throws Exception {
        postDAOLocal.addNewAricleType(articleTypeName);
        return "/AllArticleTypes.xhtml";
    }

    //this method is used to redirect editing page
    public String toEditArticleTypeName(int idArticleType) throws Exception {
        localId = idArticleType;
        //Articletype artType = this.postDAOLocal///
        //System.out.println("This message into the method");
        //System.out.println("iddddddddddddd" + localId);
        Articletype article = this.postDAOLocal.getArticleTypeInfo(idArticleType);
        this.articleTypeName = article.getName();
        return "/EditArticleTypeName.xhtml";
    }

    //this method is used to submit the edit changes
    public String editArticleTypeName() throws Exception {
        this.postDAOLocal.editArticleType(localId, articleTypeName);
        //System.out.println("into the method "+ localId);
        //System.out.println("into the method "+ articleTypeName);
        return "/AllArticleTypes.xhtml";
    }

    //this method is used to remove the article type name
    public String removeArticleTypeBean(int idArticleType) throws Exception {
        this.postDAOLocal.removeArticleType(idArticleType);
        return "/AllArticleTypes.xhtml";
    }

    //this method is used to get the page where the the articles in article type
    public String getPageArticleInArticletype(int idArticletype) throws Exception {
        this.idArticletype = idArticletype;
        return "/ArticlesInCategory.xhtml";
    }

    //this method is used to get the articles in article type
    public List<Article> getArticlesInArticletypeB(int idArticleType) throws Exception {
        return this.articleDAOLocal.getArticlesByIdArticleType(idArticleType);
    }

}
