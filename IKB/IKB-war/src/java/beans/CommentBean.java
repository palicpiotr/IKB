/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.CommentDAOLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.Comments;

/**
 *
 * @author skipp
 */
@Named(value = "commentBean")
@SessionScoped
public class CommentBean implements Serializable {

    @EJB
    private CommentDAOLocal cdaol;
    //private int idArticle;
    private Comments comment;
    private String commentAuthor;
    private String commentContent;
    private int idArticle;
    private String articleName;
    private int localId;
    private int localId2;

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public Comments getComment() {
        return comment;
    }

    public void setComment(Comments comment) {
        this.comment = comment;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String addNewComment(int idArticle) throws Exception {
        this.cdaol.addNewComment(idArticle, commentContent, commentAuthor);
        //System.out.println("MDEEEEEEEEEEEEEE " + idArticle + commentAuthor + commentContent);
        return "/AllArticles.xhtml";
    }

    //getting the page with the comment
    public String getPageWithTheComment(int idArticle) throws Exception {
        this.idArticle = idArticle;
        return "/CommentsToChoosedArticle.xhtml";
    }

    public List<Comments> getCommentsToArticle(int idArticle) throws Exception {
        System.out.print("Comment id" + idArticle);
//       this.idArticle = idArticle;
        return this.cdaol.getCommentsToArticle(idArticle);
    }
    
    public String removeComment(int idComment) throws Exception{
        this.cdaol.removeComment(idComment);
        return "/CommentsToChoosedArticle.xhtml";
    }

//    public String toEditComment(int idComment, int idArticle) throws Exception {
//        localId = idComment;
//        localId2 = idArticle;
//        //here must be some code
//        Comments comments = this.cdaol.getCommentInfo(idComment);
//        this.commentAuthor = comments.getCommentAuthor();
//        this.commentContent = comments.getCommentContent();
//        return "/EditComment.xhtml";
//    }
//
//    //this method is used to save changes in edit mode
//    public String editComment() throws Exception {
//        //System.out.println("local id ++++++++++ " + localId + idArticletype + articleName + content + addingDate);
//        //System.out.println("Id Article Type ++++++++++ " + idArticletype);
//        this.cdaol.editSelectedComment(localId, commentContent, commentAuthor, localId2);
//        return "/ArticlesInCategory.xhtml";
//    }
}
