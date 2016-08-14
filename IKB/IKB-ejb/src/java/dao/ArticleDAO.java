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
}




