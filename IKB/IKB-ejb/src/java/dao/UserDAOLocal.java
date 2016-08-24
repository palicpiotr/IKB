/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import models.User;

/**
 *
 * @author skipp
 */
@Local
public interface UserDAOLocal {

    public List<User> getAllUsers() throws Exception;

    public void addUser(String username, String password, String role) throws Exception;
}
