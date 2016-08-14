/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import models.Articletype;

/**
 *
 * @author skipp
 */
@Local
public interface PostDAOLocal {

    public List<Articletype> getAllArticleTypes() throws Exception;

    public void addNewAricleType(String articletypeName) throws Exception;

    public boolean editArticleType(int articleTypeNameID, String articletypeName) throws Exception;

    public boolean removeArticleType(int idArticleType) throws Exception;
    
    public Articletype getArticleTypeInfo(int idArticleType) throws Exception;
}
