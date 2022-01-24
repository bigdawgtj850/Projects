/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author stephenespinal
 */
public class Comment {

    private int commentId;
    private String commentText;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime commentDate;
    private int postId;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.commentId;
        hash = 97 * hash + Objects.hashCode(this.commentText);
        hash = 97 * hash + Objects.hashCode(this.commentDate);
        hash = 97 * hash + this.postId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if (this.commentId != other.commentId) {
            return false;
        }
        if (this.postId != other.postId) {
            return false;
        }
        if (!Objects.equals(this.commentText, other.commentText)) {
            return false;
        }
        if (!Objects.equals(this.commentDate, other.commentDate)) {
            return false;
        }
        return true;
    }

    
}
