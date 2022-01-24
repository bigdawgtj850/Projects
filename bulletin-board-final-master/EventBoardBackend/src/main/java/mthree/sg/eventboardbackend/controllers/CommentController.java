/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.controllers;

import java.util.List;
import mthree.sg.eventboardbackend.dtos.Comment;
import mthree.sg.eventboardbackend.dtos.Post;
import mthree.sg.eventboardbackend.services.CommentService;
import mthree.sg.eventboardbackend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author stephenespinal
 */
@RestController
@RequestMapping("/api/eventBoard/comment")
public class CommentController {

    private CommentService commentService;
    private PostService postService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    //get all comments
    @CrossOrigin
    @GetMapping("/commentsByPostId/{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable int postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    //getCommentByCommentId
    @CrossOrigin
    @GetMapping("/commentById/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable int commentId) {
        try {
            Comment comment = commentService.getCommentById(commentId);
            return ResponseEntity.ok(comment);
            //this exception can be thrown by the DAO if not found so we return the ResponseEntity back as NOT_FOUND
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("NO COMMENT FOUND", HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin
    @PostMapping("/createComment/{postId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Comment> createPost(@RequestBody Comment comment, @PathVariable int postId) {
        try {
            //if we dont get a post back from the service the EmptyResultDataAccessException will be thrown from jdbctemplate queryforobject
            Post postToAddCommentTo = postService.getPostById(postId);

            comment.setPostId(postToAddCommentTo.getPostId());
            return ResponseEntity.ok(commentService.createComment(comment));

        } catch (IllegalArgumentException e) {
            return new ResponseEntity("Invalid Data", HttpStatus.BAD_REQUEST);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("NO POST FOUND", HttpStatus.NOT_FOUND);
        }
    }

    //update post
    @CrossOrigin
    @PutMapping("/updateComment/{commentId}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment, @PathVariable int commentId) {
        try {
            //grab original comment to get the comment id 
            Comment originalComment = commentService.getCommentById(commentId);

            //set the comment's text
            originalComment.setCommentText(comment.getCommentText());

            //update the comment in service
            commentService.updateComment(originalComment);

            return ResponseEntity.ok(comment);
            //this exception can be thrown by the DAO if not found so we return the ResponseEntity back as NOT_FOUND
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("NO COMMENT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    //delete post
    @CrossOrigin
    @DeleteMapping("/deleteComment/{commentId}")
    public ResponseEntity deleteComment(@PathVariable int commentId) {
        try {
            //grab original post to get the post id and user id
            Comment commentToDelete = commentService.getCommentById(commentId);

            commentService.deleteCommentById(commentToDelete.getCommentId());

            return new ResponseEntity("COMMENT DELETED", HttpStatus.NO_CONTENT);
            //this exception can be thrown by the DAO if not found so we return the ResponseEntity back as NOT_FOUND
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("NO COMMENT FOUND", HttpStatus.NOT_FOUND);
        }
    }

}
