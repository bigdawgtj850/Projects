/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.services;

import java.time.LocalDateTime;
import java.util.List;
import mthree.sg.eventboardbackend.daos.CommentDao;
import mthree.sg.eventboardbackend.daos.PostDao;
import mthree.sg.eventboardbackend.dtos.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    
    private CommentDao commentDao;
    private PostDao postDao;
    
    @Autowired
    public CommentServiceImpl(CommentDao commentDao, PostDao postDao) {
        this.commentDao = commentDao;
        this.postDao = postDao;
    }
    
    @Override
    public Comment createComment(Comment comment) {
        
        comment.setCommentDate(LocalDateTime.now().withNano(0));
        
        return commentDao.createComment(comment);
    }
    
    @Override
    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
    }
    
    @Override
    public List<Comment> getAllCommentsByPostId(int postId) {
        return commentDao.getAllCommentsByPostId(postId);
    }
    
    @Override
    public Comment getCommentById(int commentId) {
        return commentDao.getCommentById(commentId);
    }
    
    @Override
    public void updateComment(Comment comment) {
        commentDao.updateCommentById(comment);
    }
    
    @Override
    public void deleteCommentById(int commentId) {
        commentDao.deleteCommentById(commentId);
    }
    
}
