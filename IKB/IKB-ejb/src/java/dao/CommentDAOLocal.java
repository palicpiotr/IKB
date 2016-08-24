/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import models.Comments;

/**
 *
 * @author skipp
 */
@Local
public interface CommentDAOLocal {
    
    //not used one
    public List<Comments> getAllComments() throws Exception;
    
    public void addNewComment(int idComment, String commentContent, /*Date addingDateComment*/ String commentAuthor) throws Exception;
   
    //public boolean editSelectedComment(int idComment, String commentContent, /*Date addingDateComment*/ String commentAuthor, int idArticle) throws Exception;
    
    //need
    public boolean removeComment(int idComment) throws Exception;
    
    public List<Comments> getCommentsToArticle(int idArticle) throws Exception;
    
    public Comments getCommentInfo(int idComment) throws Exception;
}
