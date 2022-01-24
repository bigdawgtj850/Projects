package mthree.sg.eventboardbackend.daos;

import java.util.List;
import mthree.sg.eventboardbackend.dtos.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stephenespinal
 */
public interface UserDao {
    
    //crud functions
    //DAO is what allows the objects to be stored in the database
    
    //so we need to specify our CRUD methods here
    /**
     * Adds a user object to the database
     *
     * @param user the user object to add
     * @return A user object that has been added to the Database
     */
    User createUser(User user);

    /**
     * Get a List of all users from the database
     *
     * @return A List of all user objects in the database
     */
    List<User> getAllUsers();

    /**
     * Get the user requested by it's id
     *
     * @param userId the id of the user to be returned
     * @return The user object that has been requested
     */
    User getUserById(int userId);
    
    /**
     * Get the user requested by it's id
     *
     * @param userName the id of the user to be returned
     * @return The user object that has been requested
     */
    User getUserByUserName(String userName);
    
    /**
     * Update the user object
     *
     * @param user the id of the user to be updated
     */
    void updateUser(User user);
    
    /**
     * Delete user by id
     *
     */
    void deleteUserById(int userId);
    
    /**
     * Delete all Users (for testing)
     *
     */
    void deleteAllUsers();
}
