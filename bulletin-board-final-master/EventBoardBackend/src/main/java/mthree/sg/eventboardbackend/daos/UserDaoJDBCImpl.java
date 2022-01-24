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

@Repository
public class UserDaoJDBCImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    public UserDaoJDBCImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User createUser(User user) {
        //create the SQL statement and add it using the jdbcTemplate update method
        final String insertUser = "INSERT INTO `User` (UserName) VALUES (?);";
        jdbcTemplate.update(insertUser, user.getUserName());
        //grab the last id made and set the game with that id to return the game with all info
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setUserId(newId);

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        final String selectAllUsers = "SELECT UserId,UserName FROM `User`;";
        return jdbcTemplate.query(selectAllUsers, new UserJDBCMapper());
    }

    @Override
    public User getUserById(int userId) {
        final String getUserById = "SELECT UserId,UserName FROM `User` WHERE UserId = ?;";
        return jdbcTemplate.queryForObject(getUserById, new UserJDBCMapper(), userId);
    }

    @Override
    public User getUserByUserName(String userName) {
        final String getUserById = "SELECT UserId,UserName FROM `User` WHERE UserName = ?;";
        return jdbcTemplate.queryForObject(getUserById, new UserJDBCMapper(), userName);
    }

    @Override
    public void updateUser(User user) {
        final String updateUser = "UPDATE User SET UserName = ? WHERE UserId = ?;";
        jdbcTemplate.update(updateUser, user.getUserName(), user.getUserId());
    }

    @Override
    @Transactional
    public void deleteUserById(int userId) {

        List<Post> allPostsByUser = postDao.getAllPostsByUserId(userId);

        for (Post post : allPostsByUser) {
            //have to delete all comments from post by the user
            final String deleteCommentByPostId = "DELETE FROM `Comment` WHERE PostId = ?;";
            jdbcTemplate.update(deleteCommentByPostId, post.getPostId());

            //next delete posts
            final String deletePostByPostId = "DELETE FROM `Post` WHERE PostId = ?;";
            jdbcTemplate.update(deletePostByPostId, post.getPostId());
        }

        final String deleteUser = "DELETE FROM `User` WHERE userId = ?;";
        jdbcTemplate.update(deleteUser, userId);
    }

    @Override
    @Transactional
    public void deleteAllUsers() {
        //delete all comments before we can delete posts
        final String deleteAllComments = "DELETE FROM Comment";
        jdbcTemplate.update(deleteAllComments);

        //delete all posts before we can delete users
        final String deleteAllPosts = "DELETE FROM Post";
        jdbcTemplate.update(deleteAllPosts);

        final String deleteAllUsers = "DELETE FROM `User`;";
        jdbcTemplate.update(deleteAllUsers);
    }

    private class UserJDBCMapper implements org.springframework.jdbc.core.RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("UserId"));
            user.setUserName(rs.getString("UserName"));

            return user;
        }
    }
}
