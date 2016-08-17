/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ArticleDAOLocal;
import dao.PostDAOLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import models.Article;
import models.Articletype;

/**
 *
 * @author skipp
 */
@Named(value = "articleBean")
@SessionScoped
public class ArticleBean implements Serializable {

    @EJB
    private ArticleDAOLocal articleDAOLocal;

    @EJB
    private PostDAOLocal postDAOLocal;
    
    private int idArticletype;

    private String articleName;
    private String content;
    private Date addingDate;
    private int localId;
    private List<Articletype> articleTypeNames;
    private int IdArticle;

    public int getIdArticle() {
        return IdArticle;
    }

    public void setIdArticle(int IdArticle) {
        this.IdArticle = IdArticle;
    }
    
    public List<Articletype> getArticleTypeNames() {
        return articleTypeNames;
    }

    public void setArticleTypeNames(List<Articletype> articleTypeNames) {
        this.articleTypeNames = articleTypeNames;
    }
    
    public int getIdArticletype() {
        return idArticletype;
    }

    public void setIdArticletype(int idArticletype) {
        this.idArticletype = idArticletype;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
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
    
    public String addNewArticle() throws Exception{
        Date date = null;
        //addingDate = Date.UTC(idArticletype, idArticletype, idArticletype, idArticletype, idArticletype, idArticletype)
        this.articleDAOLocal.addNewArticle(articleName, content, addingDate, idArticletype);
        return "/AllArticles.xhtml";
    }
    
    //this method is used to get old information about article to edit page
    public String toEditArticle(int idArticle, int idType) throws Exception{
        localId = idArticle;
        this.articleTypeNames = this.postDAOLocal.getAllArticleTypes();
        Article article = this.articleDAOLocal.getArticleInfo(idArticle);
        this.articleName = article.getArticleName();
        this.content = article.getContent();
        this.addingDate = article.getAddingDate();
        return "/EditArticle.xhtml";
    }
    
    //this method is used to save changes in edit mode
    public String editArticle() throws Exception{
        this.articleDAOLocal.editArticle(localId, articleName, content, addingDate, idArticletype);
        return "/ArticlesInCategory.xhtml";
    }
    
    //this method is used to remove article in choosed article type
    public String removeArticle(int idArticle) throws Exception{
        this.articleDAOLocal.removeArticle(IdArticle);
        return "/ArticlesInCategory.xhtml";
    }
}
