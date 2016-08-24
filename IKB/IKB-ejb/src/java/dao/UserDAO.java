/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import models.User;
import models.Usergroups;

/**
 *
 * @author skipp
 */
@Stateless
public class UserDAO implements UserDAOLocal {

   @PersistenceContext(unitName = "IKB")
    private EntityManager entityM;

    @Override
    public List<User> getAllUsers() throws Exception {
        Query query = entityM.createQuery("SELECT u FROM User u", User.class);
        List<User> usersResult = query.getResultList();
        List<User> userList = new ArrayList<>();
        Iterator<User> iter = usersResult.iterator();
        while (iter.hasNext()) {
            User us = iter.next();
            User u = new User(us.getUsername(), us.getUsergroupsList().get(0).getRole());
            userList.add(u);
        }
        return userList;
    }

    @Override
    public void addUser(String username, String pass, String role) throws Exception {
        //System.out.println("ddsdvsdvsdv" + username);
        User user = new User();
        user.setUsername(username);
        MessageDigest md = MessageDigest.getInstance("MD5");
        pass = (new HexBinaryAdapter()).marshal(md.digest(pass.getBytes(Charset.forName("UTF-8"))));
        user.setPassword(pass);
        entityM.persist(user);   
        entityM.flush();
        Usergroups usgroups = new Usergroups();
        usgroups.setUsername(user);
        usgroups.setRole(role);

        entityM.persist(usgroups);
        entityM.flush();
       
        user.getUsergroupsList().add(usgroups);
        entityM.merge(user);
        //entityM.getTransaction().commit();
    }
}
