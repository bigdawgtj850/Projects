/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.daos;

import java.util.List;
import mthree.sg.eventboardbackend.dtos.Post;

/**
 *
 * @author stephenespinal
 */
public interface PostDao {

    //crud functions
    //DAO is what allows the objects to be stored in the database
    //so we need to specify our CRUD methods here
    /**
     * Adds a post object to the database
     *
     * @param post the post object to add
     * @return A post object that has been added to the Database
     */
    Post createPost(Post post);

    /**
     * Get a List of all posts from the database
     *
     * @return A List of all post objects in the database
     */
    List<Post> getAllPosts();

    /**
     * Get a List of all posts from the database by userId
     *
     * @return A List of all post objects in the database
     */
    List<Post> getAllPostsByUserId(int userId);

    /**
     * Get a List of all posts from the database by userName
     *
     * @return A List of all post objects in the database
     */
    List<Post> getAllPostsByUserName(String userName);
    
    /**
     * Get a List of all posts from the database by userName
     *
     * @return A List of all post objects in the database
     */
    List<Post> getAllPostsByCategory(String category);

    /**
     * Get the post requested by it's id
     *
     * @param postId the id of the post to be returned
     * @return The post object that has been requested
     */
    Post getPostByPostId(int postId);

    /**
     * Get the post requested by user id
     *
     * @param userId the id of the post to be returned
     * @return The post object that has been requested
     */
    Post getPostByUserId(int userId);

    /**
     * Update the post object
     *
     * @param post the id of the post to be updated
     */
    void updatePost(Post post);

    /**
     * Delete post by id
     *
     */
    void deletePostById(int postId);

    /**
     * Delete all Posts (for testing)
     *
     */
    void deleteAllPosts();

}
