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
import models.Articletype;

/**
 *
 * @author skipp
 */
@Stateless
public class PostDAO implements PostDAOLocal {

    @PersistenceContext(unitName = "IKB")
    private EntityManager entityManager;

    @Override
    public List<Articletype> getAllArticleTypes() throws Exception {
        Query query = entityManager.createQuery("SELECT a FROM Articletype a", Articletype.class);
        return query.getResultList();
    }

    @Override
    public void addNewAricleType(String articletypeName) throws Exception {
        Articletype articleType = new Articletype();
        articleType.setName(articletypeName);
        entityManager.persist(articleType);
    }

    @Override
    public boolean editArticleType(int articleTypeNameID, String articletypeName) throws Exception {
        Articletype articleTypeName = entityManager.getReference(Articletype.class, articleTypeNameID);
        articleTypeName.setName(articletypeName);
        return true;
    }

    @Override
    public boolean removeArticleType(int idArticleType) throws Exception {
        entityManager.remove((entityManager.getReference(Articletype.class, idArticleType)));
        return true;
    }

    @Override
    public Articletype getArticleTypeInfo(int idArticleType) throws Exception {
        return entityManager.getReference(Articletype.class, idArticleType);
    }
}
