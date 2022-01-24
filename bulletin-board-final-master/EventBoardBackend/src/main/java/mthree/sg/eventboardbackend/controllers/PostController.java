/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.controllers;

import java.util.List;
import mthree.sg.eventboardbackend.dtos.Post;
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
@RequestMapping("/api/eventBoard/post")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //get all posts
    @CrossOrigin
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

//    //getPostsByUserName
//    @CrossOrigin
//    @GetMapping("/posts/{userName}")
//    public List<Post> getPostsByUserName(@PathVariable String userName) {
//        return postService.getAllPostsByUserName(userName);
//    }

    //getPostsByCategory
    @CrossOrigin
    @GetMapping("/posts/{category}")
    public List<Post> getPostsByCategory(@PathVariable String category) {
        return postService.getAllPostsByCategory(category);
    }

    //create round
    @CrossOrigin
    @PostMapping("/createPost")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        try {
            return ResponseEntity.ok(postService.createPost(post));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity("Invalid Data", HttpStatus.BAD_REQUEST);
        }
    }

    //getPostByPostId
    @CrossOrigin
    @GetMapping("/getPost/{postId}")
    public ResponseEntity<Post> getPostByPostId(@PathVariable int postId) {
        try {
            Post post = postService.getPostById(postId);
            return ResponseEntity.ok(post);
            //this exception can be thrown by the DAO if not found so we return the ResponseEntity back as NOT_FOUND
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("NO POST FOUND", HttpStatus.NOT_FOUND);
        }

    }

    //update post
    @CrossOrigin
    @PutMapping("/updatePost/{postId}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable int postId) {
        try {
            //grab original post to get the post id and user id
            Post originalPost = postService.getPostById(postId);

            //set the updated post's ids correctly
            post.setPostId(originalPost.getPostId());
            post.setUser(originalPost.getUser());

            //update the post
            postService.updatePost(post);

            return ResponseEntity.ok(post);
            //this exception can be thrown by the DAO if not found so we return the ResponseEntity back as NOT_FOUND
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("NO POST FOUND", HttpStatus.NOT_FOUND);
        }
    }

    //delete post
    @CrossOrigin
    @DeleteMapping("/deletePost/{postId}")
    public ResponseEntity deletePost(@PathVariable int postId) {
        try {
            //grab original post to get the post id and user id
            Post postToDelete = postService.getPostById(postId);

            postService.deletePostById(postToDelete.getPostId());

            return new ResponseEntity("POST DELETED", HttpStatus.NO_CONTENT);
            //this exception can be thrown by the DAO if not found so we return the ResponseEntity back as NOT_FOUND
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("NO POST FOUND", HttpStatus.NOT_FOUND);
        }
    }

}
