/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import mthree.sg.eventboardbackend.dtos.Comment;
import mthree.sg.eventboardbackend.dtos.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CommentDaoImpl implements CommentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Comment createComment(Comment comment) {
        //create the SQL statement and add it using the jdbcTemplate update method
        final String insertComment = "INSERT INTO `Comment` (CommentText,`Date`,PostId) VALUES (?,?,?);";
        jdbcTemplate.update(insertComment, comment.getCommentText(),comment.getCommentDate(),comment.getPostId());

        //grab the last id made and set the game with that id to return the game with all info
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        comment.setCommentId(newId);

        return comment;
    }

    @Override
    public List<Comment> getAllComments() {
        final String selectAllComments = "SELECT CommentId,CommentText,Date,PostId FROM Comment;";
        return jdbcTemplate.query(selectAllComments, new CommentJDBCMapper());
    }

    @Override
    public List<Comment> getAllCommentsByPostId(int postId){
        final String selectAllCommentsByPostId = "SELECT CommentId,CommentText,Date,PostId FROM Comment WHERE PostId = ?;";
        return jdbcTemplate.query(selectAllCommentsByPostId, new CommentJDBCMapper(), postId);
    }

    @Override
    public Comment getCommentById(int commentId) {
        final String getCommentById = "SELECT * FROM Comment WHERE CommentId = ?;";
        return jdbcTemplate.queryForObject(getCommentById, new CommentJDBCMapper(), commentId);
    }

    @Override
    public void updateCommentById(Comment comment) {
        final String updateComment = "UPDATE `Comment` SET CommentText = ? WHERE CommentId = ?;";
        jdbcTemplate.update(updateComment, comment.getCommentText(), comment.getCommentId());
    }

    @Override
    public void deleteCommentById(int commentId) {
        final String deleteComment = "DELETE FROM `Comment` WHERE CommentId = ?;";
        jdbcTemplate.update(deleteComment, commentId);
    }

    @Override
    public void deleteAllComments() {
        final String deleteAllComments = "DELETE FROM `Comment`;";
        jdbcTemplate.update(deleteAllComments);
    }

    private class CommentJDBCMapper implements org.springframework.jdbc.core.RowMapper<Comment> {

        @Override
        public Comment mapRow(ResultSet rs, int i) throws SQLException {
            Comment comment = new Comment();

            comment.setCommentId(rs.getInt("CommentId"));
            comment.setCommentText(rs.getString("CommentText"));
            comment.setCommentDate(rs.getTimestamp("Date").toLocalDateTime());
            comment.setPostId(rs.getInt("PostId"));

            return comment;
        }
    }

}
