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
import models.Comments;

/**
 *
 * @author skipp
 */
@Stateless
public class CommentDAO implements CommentDAOLocal {

    @PersistenceContext(unitName = "IKB")
    private EntityManager entityManager;

//    Query query = entityManager.createQuery("SELECT a FROM Articletype a", Articletype.class);
//        return query.getResultList();
    @Override
    public List<Comments> getAllComments() throws Exception {
        Query query = entityManager.createQuery("SELECT c FROM Comments c", Comments.class);
        return query.getResultList();
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

//    @Override
//    public boolean editSelectedComment(int idComment, String commentContent, String commentAuthor, int idArticle) throws Exception {
//        Comments comments = entityManager.getReference(Comments.class, idComment);
//        Article article = entityManager.getReference(Article.class, comments.getIdArticle().getIdArticle());
//        /*boolean remove*/ article.getCommentsList().remove(comments);
//        entityManager.merge(article);
//        comments.setCommentAuthor(commentAuthor);
//        comments.setCommentContent(commentContent);
//        java.util.Calendar calendar = java.util.Calendar.getInstance();
//        java.util.Date addingDate = calendar.getTime();
//        comments.setAddingDateComment(addingDate);
//        comments.setIdArticle(entityManager.getReference(Article.class, idArticle));
//        article = entityManager.getReference(Article.class, idArticle);
//        article.getCommentsList().add(comments);
//        entityManager.merge(article);
//        return true;
    //}
// @Override
//    public boolean editArticle(int idArticle, String articleName, String content, /*Date addingDate,*/ int idType, String articleAuthor) throws Exception {
//        Article article = entityManager.getReference(Article.class, idArticle);
//        Articletype articleType = entityManager.getReference(Articletype.class, article.getIdType().getIdType());
//        articleType.getArticleList().remove(article);
//        entityManager.merge(articleType);
//        article.setArticleName(articleName);
//        article.setContent(content);
//        java.util.Calendar calendar = java.util.Calendar.getInstance();
//        java.util.Date addingDate = calendar.getTime();
//        article.setAddingDate(addingDate);
//        article.setArticleAuthor(articleAuthor);
//        article.setIdType(entityManager.getReference(Articletype.class, idType));
//        articleType = entityManager.getReference(Articletype.class, idType);
////        System.out.println("AAA: " + idType);
////        System.out.println("AAA: " + addingDate);
////        System.out.println("AAA: " + articleType.getIdType());
//        articleType.getArticleList().add(article);
//        entityManager.merge(articleType);
//        return true;
//    }
    
    @Override
    public boolean removeComment(int idComment) throws Exception {
        Article article = entityManager.getReference(Article.class, entityManager.getReference(Comments.class, idComment).getIdArticle().getIdArticle());
        entityManager.remove(entityManager.getReference(Comments.class, idComment));
        entityManager.refresh(article);
        return true;
    }

    @Override
    public List<Comments> getCommentsToArticle(int idArticle) throws Exception {
        TypedQuery<Comments> query = entityManager.createQuery("SELECT c FROM Comments c WHERE c.idArticle = ?1", Comments.class);
        //System.out.println("Id Article from DAO " + idArticle);
        //Comments com = new Comments();
        return query.setParameter(1, entityManager.getReference(Article.class, idArticle)).getResultList();
        //Object obj = query.getResultList();
        //return query.getResultList();
        //return query.setParameter(1, idArticle).getResultList();
    }
//     public List<Article> getArticleContentByName(String articleName) throws Exception {
//        TypedQuery<Article> query = entityManager.createQuery("SELECT a FROM Article a WHERE a.articleName = ?1", Article.class);
//        return query.setParameter(1, articleName).getResultList();

    @Override
    public Comments getCommentInfo(int idComment) throws Exception {
        return entityManager.getReference(Comments.class, idComment);
    }
}
