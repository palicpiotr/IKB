/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import models.Article;
import models.Articletype;

/**
 *
 * @author skipp
 */
@Stateless
public class ArticleDAO implements ArticleDAOLocal {

    @PersistenceContext(unitName = "IKB")
    private EntityManager entityManager;

    //this method is used to get the all article names into the LIST
    @Override
    public List<Article> getAllArticles() throws Exception {
        Query query = entityManager.createQuery("SELECT a FROM Article a", Article.class);
        return query.getResultList();
    }

    //this method is used to get the artyicles by article type yani category into the LIST
    @Override
    public List<Article> getArticlesByIdArticleType(int idType) throws Exception {
        Articletype articleT = entityManager.getReference(Articletype.class, idType);
        return articleT.getArticleList();
    }

    //this method is used to add the new article 
    @Override
    public void addNewArticle(String articleName, String content, /*Date addingDate,*/ int idType) throws Exception {
        Article article = new Article();
        article.setArticleName(articleName);
        article.setContent(content);
        //article.setAddingDate(addingDate);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        java.util.Date addingDate = calendar.getTime();
        article.setAddingDate(addingDate);
        article.setIdType(entityManager.getReference(Articletype.class, idType));
        entityManager.persist(article);
        Articletype articletype = entityManager.getReference(Articletype.class, idType);
//        System.out.println("AAA: " + idType);
//        System.out.println("AAA: " + addingDate);
//        System.out.println("AAA: " + articletype.getIdType());
        articletype.getArticleList().add(article);
        entityManager.merge(articletype);
    }

    //this method is used to edit the choosed article
    @Override
    public boolean editArticle(int idArticle, String articleName, String content, /*Date addingDate,*/ int idType) throws Exception {
        Article article = entityManager.getReference(Article.class, idArticle);
        Articletype articleType = entityManager.getReference(Articletype.class, article.getIdType().getIdType());
        articleType.getArticleList().remove(article);
        entityManager.merge(articleType);
        article.setArticleName(articleName);
        article.setContent(content);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        java.util.Date addingDate = calendar.getTime();
        article.setAddingDate(addingDate);
        article.setIdType(entityManager.getReference(Articletype.class, idType));
        articleType = entityManager.getReference(Articletype.class, idType);
//        System.out.println("AAA: " + idType);
//        System.out.println("AAA: " + addingDate);
//        System.out.println("AAA: " + articleType.getIdType());
        articleType.getArticleList().add(article);
        entityManager.merge(articleType);
        return true;
    }

   //this method is used to get info about the selected article
    @Override
    public Article getArticleInfo(int idArticle) throws Exception {
        return entityManager.getReference(Article.class, idArticle);
    }

    //this method is used to remove the article
    @Override
    public boolean removeArticle(int idArticle) throws Exception {
        Articletype articleType = entityManager.getReference(Articletype.class, entityManager.getReference(Article.class, idArticle).getIdType().getIdType());
        entityManager.remove(entityManager.getReference(Article.class, idArticle));
        entityManager.refresh(articleType);
        //entityManager.remove((entityManager.getReference(Articletype.class, idArticleType)));
        return true;
    }

    //this method is used to get content of the choosed article name
    @Override
    public List<Article> getArticleContentByName(String articleName) throws Exception {
        TypedQuery<Article> query = entityManager.createQuery("SELECT a FROM Article a WHERE a.articleName = ?1", Article.class);
        return query.setParameter(1, articleName).getResultList();
    }
    
}
