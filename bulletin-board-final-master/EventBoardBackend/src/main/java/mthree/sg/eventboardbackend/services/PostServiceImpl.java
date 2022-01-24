/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.services;

import java.util.List;
import mthree.sg.eventboardbackend.daos.PostDao;
import mthree.sg.eventboardbackend.daos.UserDao;
import mthree.sg.eventboardbackend.dtos.Post;
import mthree.sg.eventboardbackend.dtos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostDao postDao;
    private UserDao userDao;

    @Autowired
    public PostServiceImpl(PostDao postDao, UserDao userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @Override
    public Post createPost(Post post) {

        User user;

        //check if user exists, if not then create new one
        //if we get an empty result, this exception is thrown by jdbcTemplate queryForObject method
        try {
            //if the username exists, put it in the post if not create one
            user = userDao.getUserByUserName(post.getUser().getUserName());

        } catch (EmptyResultDataAccessException e) {
            user = userDao.createUser(post.getUser());
        }

        post.setUser(user);
        post = postDao.createPost(post);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = postDao.getAllPosts();
        return posts;
    }

    @Override
    public List<Post> getAllPostsByUserId(int userId) {
        List<Post> posts = postDao.getAllPostsByUserId(userId);
        return posts;
    }

    @Override
    public List<Post> getAllPostsByUserName(String userName) {
        List<Post> posts = postDao.getAllPostsByUserName(userName);
        return posts;
    }

    @Override
    public List<Post> getAllPostsByCategory(String category) {
        List<Post> posts = postDao.getAllPostsByCategory(category);
        return posts;
    }

    @Override
    public Post getPostById(int postId) {
        return postDao.getPostByPostId(postId);
    }

    @Override
    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    @Override
    public void deletePostById(int postId) {
        postDao.deletePostById(postId);
    }

}
