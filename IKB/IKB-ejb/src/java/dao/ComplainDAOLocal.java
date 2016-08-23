/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import models.Complain;

/**
 *
 * @author skipp
 */
@Local
public interface ComplainDAOLocal {

    public List<Complain> getAllComplains() throws Exception;

    public List<Complain> getComplainsForArticle(int idArticle) throws Exception;
    
    public void addTheComplain(int articleId, String complainType, String complainAuthor, String complainContent) throws Exception;
}
