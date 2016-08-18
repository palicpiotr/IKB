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
    private int localId2;
    private String articleAuthor;
    //public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
    //public static String now() {
    //  Calendar cal = Calendar.getInstance();
    //  SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    // return sdf.format(cal.getTime());
    // }
    //@PostConstruct
    // public void initialize() {
    //  java.util.Calendar cal = java.util.Calendar.getInstance();
    //  java.util.Date utilDate = cal.getTime();
    // addingDate = utilDate;
    // }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }
    
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
    public String addNewArticle() throws Exception {
        //Date date = null;
        //addingDate = Date.UTC(idArticletype, idArticletype, idArticletype, idArticletype, idArticletype, idArticletype)
        //Calendar now = Calendar.getInstance();
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Calendar cal = Calendar.getInstance();
        //dateFormat.format(cal.getTime()),
        //Date date = cal.getTime();
        //java.util.Calendar cal = java.util.Calendar.getInstance();
        //java.util.Date utilDate = cal.getTime();
        //java.util.Date sqlDate =  new Date(utilDate.getTime());
        this.articleDAOLocal.addNewArticle(articleName, content, /*((Date) utilDate),*/ idArticletype, articleAuthor);
        return "/ArticlesInCategory.xhtml";
    }

    //this method is used to get old information about article to edit page
    public String toEditArticle(int idArticle, int idType) throws Exception {
        localId = idArticle;
        localId2 = idType;
        System.out.println("ASSSSSSSSSSSSSSSSSS: " + idType);
        this.articleTypeNames = this.postDAOLocal.getAllArticleTypes();
        Article article = this.articleDAOLocal.getArticleInfo(idArticle);
        this.articleName = article.getArticleName();
        this.content = article.getContent();
        this.articleAuthor = article.getArticleAuthor();
        //this.addingDate = article.getAddingDate();
        return "/EditArticle.xhtml";
    }

    //this method is used to save changes in edit mode
    public String editArticle() throws Exception {
        //System.out.println("local id ++++++++++ " + localId + idArticletype + articleName + content + addingDate);
        //System.out.println("Id Article Type ++++++++++ " + idArticletype);
        this.articleDAOLocal.editArticle(localId, articleName, content, /*addingDate,*/ /*idArticletype*/ localId2, articleAuthor);
        return "/ArticlesInCategory.xhtml";
    }

    //this method is used to remove article in choosed article type
    public String removeArticle(int idArticle) throws Exception {
        this.articleDAOLocal.removeArticle(idArticle);
        return "/ArticlesInCategory.xhtml";
    }
   
    //this method is used to redirecting the user to page where is the details about choosed article
    public String getPageWithContent(String articleName) throws Exception{
        this.articleName = articleName;
        return "/ChoosedArticleName.xhtml";
    }
    
     //this method is used to get the content in article
    public List<Article> getArticleContent(String articleName) throws Exception{
        return this.articleDAOLocal.getArticleContentByName(articleName);
    }
}
