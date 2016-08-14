/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ArticleDAOLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import models.Article;

/**
 *
 * @author skipp
 */
@Named(value = "articleBean")
@SessionScoped
public class ArticleBean implements Serializable {

    @EJB
    private ArticleDAOLocal articleDAOLocal;

    private int idArticletype;

    public int getIdArticletype() {
        return idArticletype;
    }

    public void setIdArticletype(int idArticletype) {
        this.idArticletype = idArticletype;
    }

    public List<Article> getAllArticlesB() throws Exception {
        return this.articleDAOLocal.getAllArticles();
        //return "/AllArticles.xhtml";
    }

    //this method is used to get the page where the the articles in article type
   /* public String getPageArticleInArticletype(int idArticletype) throws Exception {
        this.idArticletype = idArticletype;
        return "/ArticlesInCategory.xhtml";
    }

    //this method is used to get the articles in article type
    public List<Article> getArticlesInArticletypeB(int idArticleType) throws Exception {
        return this.articleDAOLocal.getArticlesByIdArticleType(idArticleType);
    }
*/
}
