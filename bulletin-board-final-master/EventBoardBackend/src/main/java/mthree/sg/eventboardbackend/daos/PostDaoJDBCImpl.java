/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import mthree.sg.eventboardbackend.dtos.Post;
import mthree.sg.eventboardbackend.dtos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author stephenespinal
 */
@Repository
public class PostDaoJDBCImpl implements PostDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDaoJDBCImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Post createPost(Post post) {
        //create the SQL statement and add it using the jdbcTemplate update method
        final String insertPost = "INSERT INTO Post (Title,Category,Address,ZipCode,Preview,EventInfo,`Date`,UserId) VALUES (?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(insertPost, post.getTitle(), post.getCategory(), post.getAddressString(), post.getZipCode(),
                post.getPreview(), post.getEventInfo(), post.getDateOfEvent(), post.getUser().getUserId());
        //grab the last id made and set the game with that id to return the game with all info
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        post.setPostId(newId);

        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        final String selectAllPosts = "SELECT PostId,Title,Category,Address,ZipCode,Preview,EventInfo,`Date`, Post.UserId, UserName "
                + "FROM Post JOIN `User` ON Post.UserId = `User`.UserId;";
        return jdbcTemplate.query(selectAllPosts, new PostJDBCMapper());
    }

    @Override
    public List<Post> getAllPostsByUserId(int userId) {
        final String selectAllPosts = "SELECT PostId,Title,Category,Address,ZipCode,Preview,EventInfo,`Date`, Post.UserId, UserName "
                + "FROM Post JOIN `User` ON Post.UserId = `User`.UserId WHERE Post.UserId = ?;";
        return jdbcTemplate.query(selectAllPosts, new PostJDBCMapper(), userId);
    }
    
    @Override
    public List<Post> getAllPostsByCategory(String category) {
        final String selectAllPosts = "SELECT PostId,Title,Category,Address,ZipCode,Preview,EventInfo,`Date`, Post.UserId, UserName "
                + "FROM Post JOIN `User` ON Post.UserId = `User`.UserId WHERE Category = ?;";
        return jdbcTemplate.query(selectAllPosts, new PostJDBCMapper(), category);
    }

    @Override
    public List<Post> getAllPostsByUserName(String userName) {
        final String selectAllPosts = "SELECT PostId,Title,Category,Address,ZipCode,Preview,EventInfo,`Date`, Post.UserId, UserName "
                + "FROM Post JOIN `User` ON Post.UserId = `User`.UserId WHERE UserName = ?;";
        return jdbcTemplate.query(selectAllPosts, new PostJDBCMapper(), userName);    }

    @Override
    public Post getPostByPostId(int postId) {
        final String getPostById = "SELECT PostId,Title,Category,Address,ZipCode,Preview,EventInfo,`Date`, "
                + "Post.UserId, UserName FROM Post JOIN `User` ON Post.UserId = `User`.UserId WHERE PostId = ?;";
        return jdbcTemplate.queryForObject(getPostById, new PostJDBCMapper(), postId);
    }

    @Override
    public Post getPostByUserId(int userId) {
        final String getPostById = "SELECT PostId,Title,Category,Address,ZipCode,Preview,EventInfo,`Date`, Post.UserId, "
                + "UserName FROM Post JOIN `User` ON Post.UserId = `User`.UserId WHERE Post.UserId = ?;";
        return jdbcTemplate.queryForObject(getPostById, new PostJDBCMapper(), userId);
    }

    @Override

    public void updatePost(Post post) {
        final String updatePost = "UPDATE Post SET Title = ?,Category = ?,Address = ?,ZipCode = ?,Preview = ?,EventInfo = ?,`Date` = ?,UserId = ? WHERE PostId = ?;";
        jdbcTemplate.update(updatePost, post.getTitle(), post.getCategory(), post.getAddressString(), post.getZipCode(), post.getPreview(), post.getEventInfo(),
                post.getDateOfEvent(), post.getUser().getUserId(), post.getPostId());
    }

    @Override
    @Transactional
    public void deletePostById(int postId) {

        //need to deleteAllComments on this post
        final String deleteCommentByPostId = "DELETE FROM Comment WHERE PostId = ?";
        jdbcTemplate.update(deleteCommentByPostId, postId);

        final String deletePost = "DELETE FROM Post WHERE PostId = ?;";
        jdbcTemplate.update(deletePost, postId);
    }

    @Override
    @Transactional
    public void deleteAllPosts() {
        //need to delete all comments
        //delete all comments before we can delete posts
        final String deleteAllComments = "DELETE FROM Comment";
        jdbcTemplate.update(deleteAllComments);

        final String deleteAllPosts = "DELETE FROM Post";
        jdbcTemplate.update(deleteAllPosts);
    }

    private class PostJDBCMapper implements org.springframework.jdbc.core.RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int i) throws SQLException {
            Post post = new Post();
            post.setPostId(rs.getInt("PostId"));
            post.setTitle(rs.getString("Title"));
            post.setCategory(rs.getString("Category"));
            post.setAddressString(rs.getString("Address"));
            post.setZipCode(rs.getString("ZipCode"));
            post.setPreview(rs.getString("Preview"));
            post.setEventInfo(rs.getString("EventInfo"));
            post.setDateOfEvent(rs.getString("Date"));

            User user = new User();
            user.setUserId(Integer.parseInt(rs.getString("Post.UserId")));
            user.setUserName(rs.getString("UserName"));
            post.setUser(user);

            return post;
        }

    }

}
