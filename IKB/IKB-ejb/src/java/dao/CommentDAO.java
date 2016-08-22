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
import models.Comments;

/**
 *
 * @author skipp
 */
@Stateless
public class CommentDAO implements CommentDAOLocal {

    @PersistenceContext(unitName = "IKB")
    private EntityManager entityManager;

    @Override
    public List<Comments> getAllComments() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNewComment(int idArticle, String commentContent, String commentAuthor) throws Exception {
        Comments comment = new Comments();
        comment.setCommentContent(commentContent);
        comment.setCommentAuthor(commentAuthor);
        //article.setAddingDate(addingDate);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        java.util.Date addingDate = calendar.getTime();
        comment.setAddingDateComment(addingDate);
        comment.setIdArticle(entityManager.getReference(Article.class, idArticle));
        entityManager.persist(comment);
        Article article = entityManager.getReference(Article.class, idArticle);
        article.getCommentsList().add(comment);
        entityManager.merge(article);
    }

    @Override
    public boolean editSelectedComment(int idArticle, String commentContent, String commentAuthor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeComment(int idArticle) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comments> getCommentsToArticle(int idArticle) throws Exception {
        TypedQuery<Comments> query = entityManager.createQuery("SELECT c FROM Comments c WHERE c.idArticle = ?1", Comments.class);
        System.out.println("Id Article from DAO " + idArticle);
        //Comments com = new Comments();
        return query.setParameter(1, idArticle).getResultList();
        //Object obj = query.getResultList();
        //return query.getResultList();
        //return query.setParameter(1, idArticle).getResultList();
    }
//     public List<Article> getArticleContentByName(String articleName) throws Exception {
//        TypedQuery<Article> query = entityManager.createQuery("SELECT a FROM Article a WHERE a.articleName = ?1", Article.class);
//        return query.setParameter(1, articleName).getResultList();
}
