/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.daos;

import java.util.List;
import mthree.sg.eventboardbackend.dtos.Comment;

/**
 *
 * @author Rahman Mhate
 */
public interface CommentDao {

    //crud functions
    //DAO is what allows the objects to be stored in the database
    //so we need to specify our CRUD methods here
    /**
     * Adds a comment object to the database
     *
     * @param comment the comment object to add
     * @return A comment object that has been added to the Database
     */
    Comment createComment(Comment comment);

    /**
     * Get a List of all comments from the database
     *
     * @return A List of all comment objects in the database
     */
    List<Comment> getAllComments();

    /**
     * Get a List of all comments from the dao by post Id
     *
     * @param postId the post id to look for
     * @return A List of all comment objects in the dao
     */
    List<Comment> getAllCommentsByPostId(int postId);

    /**
     * Get the comment requested by it's id
     *
     * @param CommentId the id of the comment to be returned
     * @return The comment object that has been requested
     */
    Comment getCommentById(int commentId);

    /**
     * Adds a comment object to the database
     *
     * @param comment the comment object to add
     * @return A comment object that has been added to the Database
     */
    void updateCommentById(Comment comment);

    /**
     * Delete comment by id
     *
     */
    void deleteCommentById(int commentId);

    /**
     * Delete comment by id
     *
     */
    void deleteAllComments();

}
