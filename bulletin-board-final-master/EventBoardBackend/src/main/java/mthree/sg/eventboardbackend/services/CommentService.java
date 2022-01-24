/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.services;

import java.util.List;
import mthree.sg.eventboardbackend.dtos.Comment;

/**
 *
 * @author stephenespinal
 */
public interface CommentService {

    //so we need to specify our CRUD methods here
    /**
     * Adds a comment object to the dao does validation on the comment object
     *
     * @param comment the comment object to add
     * @return A comment object that has been added to the dao
     */
    Comment createComment(Comment comment);

    /**
     * Get a List of all comments from the dao
     *
     * @return A List of all comment objects in the dao
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
     * @param commentId the id of the comment to be returned
     * @return The comment object that has been requested
     */
    Comment getCommentById(int commentId);

    /**
     * Update the comment object
     *
     * @param comment the id of the comment to be updated
     */
    void updateComment(Comment comment);

    /**
     * Delete comment by id
     *
     * @param commentId the id of the comment to be updated
     *
     */
    void deleteCommentById(int commentId);

}
