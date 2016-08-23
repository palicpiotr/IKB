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
import javax.persistence.TypedQuery;
import models.Article;
import models.Complain;

/**
 *
 * @author skipp
 */
@Stateless
public class ComplainDAO implements ComplainDAOLocal {

    @PersistenceContext(unitName = "IKB")
    private EntityManager entityManager;

    @Override
    public List<Complain> getAllComplains() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //this method is used to show the complains for article
    @Override
    public List<Complain> getComplainsForArticle(int idComplain) throws Exception {
        TypedQuery<Complain> query = entityManager.createQuery("SELECT c FROM Complain c WHERE c.articleID = ?1", Complain.class);
        return query.setParameter(1, entityManager.getReference(Complain.class, idComplain)).getResultList();
    }

    @Override
    public void addTheComplain(int idArticle, String complainType, String complainAuthor, String complainContent) throws Exception {
        Complain complain = new Complain();
        complain.setComplainAuthor(complainAuthor);
        complain.setType(complainType);
        complain.setComplainContent(complainContent);
        //если не забуду, добавлю и дату жалобы)))
        //не забыл и добавил
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        java.util.Date addingDate = calendar.getTime();
        complain.setAddingDate(addingDate);
        complain.setArticleID(entityManager.getReference(Article.class, idArticle));
        entityManager.persist(complain);
        Article article = entityManager.getReference(Article.class, idArticle);
        article.getComplainList().add(complain);
        entityManager.merge(article);
    }
}
