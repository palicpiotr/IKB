/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import models.Article;

/**
 *
 * @author skipp
 */
@Local
public interface ArticleDAOLocal {
    
    public List<Article> getAllArticles() throws Exception;
    
    public List<Article> getArticlesByIdArticleType(int idType) throws Exception;
    
    public void addNewArticle(String articleName, String content, Date addingDate, int idType) throws Exception;
    
    public boolean editArticle(int idArticle, String articleName, String content, Date addingDate, int idType) throws Exception;
    
    public Article getArticleInfo(int idArticle) throws Exception;
    
    public boolean removeArticle(int idArticle) throws Exception;
}
