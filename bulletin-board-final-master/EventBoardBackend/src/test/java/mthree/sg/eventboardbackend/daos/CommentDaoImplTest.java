/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.daos;

import java.time.LocalDateTime;
import java.util.List;
import mthree.sg.eventboardbackend.dtos.Comment;
import mthree.sg.eventboardbackend.dtos.Post;
import mthree.sg.eventboardbackend.dtos.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author stephenespinal
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoImplTest {

    @Autowired
    UserDao userDao;

    @Autowired
    PostDao postDao;

    @Autowired
    CommentDao commentDao;

    public CommentDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        userDao.deleteAllUsers();
    }

    @After
    public void tearDown() {
    }

//    /**
//     * Test of createComment method, of class CommentDaoImpl.
//     */
//    @Test
//    public void testCreateComment() {
//
//        //arrange, act, assert
//        //create post to test creation
//        User user = new User();
//        user.setUserName("userName");
//
//        user = userDao.createUser(user);
//
//        Post postToTest = new Post();
//        postToTest.setTitle("title");
//        postToTest.setCategory("category");
//        postToTest.setAddressString("address");
//        postToTest.setZipCode("zip");
//        postToTest.setPreview("preview");
//        postToTest.setEventInfo("eventInfo");
//        postToTest.setDateOfEvent(LocalDateTime.now());
//        postToTest.setUser(user);
//
//        postToTest = postDao.createPost(postToTest);
//
//        Comment comment = new Comment();
//        comment.setCommentText("comment");
//        comment.setCommentDate(LocalDateTime.now().withNano(0));
//        comment.setPostId(postToTest.getPostId());
//        comment = commentDao.createComment(comment);
//
//        Comment commentFromDao = commentDao.getCommentById(comment.getCommentId());
//
//        assertEquals(comment, commentFromDao);
//    }
//
//    /**
//     * Test of getAllComments method, of class CommentDaoImpl.
//     */
//    @Test
//    public void testGetAllComments() {
//        //arrange, act, assert
//        //create post to test creation
//        User user = new User();
//        user.setUserName("userName");
//
//        user = userDao.createUser(user);
//
//        Post postToTest = new Post();
//        postToTest.setTitle("title");
//        postToTest.setCategory("category");
//        postToTest.setAddressString("address");
//        postToTest.setZipCode("zip");
//        postToTest.setPreview("preview");
//        postToTest.setEventInfo("eventInfo");
//        postToTest.setDateOfEvent(LocalDateTime.now());
//        postToTest.setUser(user);
//
//        postToTest = postDao.createPost(postToTest);
//
//        Comment comment = new Comment();
//        comment.setCommentText("comment");
//        comment.setCommentDate(LocalDateTime.now().withNano(0));
//        comment.setPostId(postToTest.getPostId());
//        comment = commentDao.createComment(comment);
//
//        List<Comment> comments = commentDao.getAllComments();
//
//        assertEquals(comment, comments.get(0));
//    }
//    
//        /**
//     * Test of getAllComments method, of class CommentDaoImpl.
//     */
//    @Test
//    public void testGetAllCommentsByPostId() {
//        //arrange, act, assert
//        //create post to test creation
//        User user = new User();
//        user.setUserName("userName");
//
//        user = userDao.createUser(user);
//
//        Post postToTest = new Post();
//        postToTest.setTitle("title");
//        postToTest.setCategory("category");
//        postToTest.setAddressString("address");
//        postToTest.setZipCode("zip");
//        postToTest.setPreview("preview");
//        postToTest.setEventInfo("eventInfo");
//        postToTest.setDateOfEvent(LocalDateTime.now().withNano(0));
//        postToTest.setUser(user);
//
//        postToTest = postDao.createPost(postToTest);
//
//        Comment comment = new Comment();
//        comment.setCommentText("comment");
//        comment.setCommentDate(LocalDateTime.now().withNano(0));
//        comment.setPostId(postToTest.getPostId());
//        comment = commentDao.createComment(comment);
//
//        List<Comment> comments = commentDao.getAllCommentsByPostId(postToTest.getPostId());
//
//        assertEquals(comment, comments.get(0));
//    }
//
//    /**
//     * Test of getCommentById method, of class CommentDaoImpl.
//     */
//    @Test
//    public void testGetCommentById() {
//        //arrange, act, assert
//        //create post to test creation
//        User user = new User();
//        user.setUserName("userName");
//
//        user = userDao.createUser(user);
//
//        Post postToTest = new Post();
//        postToTest.setTitle("title");
//        postToTest.setCategory("category");
//        postToTest.setAddressString("address");
//        postToTest.setZipCode("zip");
//        postToTest.setPreview("preview");
//        postToTest.setEventInfo("eventInfo");
//        postToTest.setDateOfEvent(LocalDateTime.now());
//        postToTest.setUser(user);
//
//        postToTest = postDao.createPost(postToTest);
//
//        Comment comment = new Comment();
//        comment.setCommentText("comment");
//        comment.setCommentDate(LocalDateTime.now().withNano(0));
//        comment.setPostId(postToTest.getPostId());
//        comment = commentDao.createComment(comment);
//
//        Comment commentFromDao = commentDao.getCommentById(comment.getCommentId());
//
//        assertEquals(comment, commentFromDao);
//    }
//
//    /**
//     * Test of updateCommentById method, of class CommentDaoImpl.
//     */
//    @Test
//    public void testUpdateCommentById() {
//
//        //arrange, act, assert
//        //create post to test creation
//        User user = new User();
//        user.setUserName("userName");
//
//        user = userDao.createUser(user);
//
//        Post postToTest = new Post();
//        postToTest.setTitle("title");
//        postToTest.setCategory("category");
//        postToTest.setAddressString("address");
//        postToTest.setZipCode("zip");
//        postToTest.setPreview("preview");
//        postToTest.setEventInfo("eventInfo");
//        postToTest.setDateOfEvent(LocalDateTime.now().withNano(0));
//        postToTest.setUser(user);
//
//        postToTest = postDao.createPost(postToTest);
//
//        Comment comment = new Comment();
//        comment.setCommentText("comment");
//        comment.setCommentDate(LocalDateTime.now().withNano(0));
//        comment.setPostId(postToTest.getPostId());
//        comment = commentDao.createComment(comment);
//
//        //act
//        comment.setCommentText("updated");
//        commentDao.updateCommentById(comment);
//        
//        Comment commentFromDao = commentDao.getCommentById(comment.getCommentId());
//
//        assertEquals("updated", commentFromDao.getCommentText());
//    }
//
//    /**
//     * Test of deleteCommentById method, of class CommentDaoImpl.
//     */
//    @Test
//    public void testDeleteCommentById() {
//        User user = new User();
//        user.setUserName("userName");
//
//        user = userDao.createUser(user);
//
//        Post postToTest = new Post();
//        postToTest.setTitle("title");
//        postToTest.setCategory("category");
//        postToTest.setAddressString("address");
//        postToTest.setZipCode("zip");
//        postToTest.setPreview("preview");
//        postToTest.setEventInfo("eventInfo");
//        postToTest.setDateOfEvent(LocalDateTime.now().withNano(0));
//        postToTest.setUser(user);
//        postToTest = postDao.createPost(postToTest);
//
//        Comment comment = new Comment();
//        comment.setCommentText("comment");
//        comment.setCommentDate(LocalDateTime.now().withNano(0));
//        comment.setPostId(postToTest.getPostId());
//        comment = commentDao.createComment(comment);
//
//        //act
//        commentDao.deleteCommentById(comment.getCommentId());
//
//        List<Comment> comments = commentDao.getAllComments();
//
//        assertTrue(comments.size() == 0);
//    }
//
//    /**
//     * Test of deleteAllComments method, of class CommentDaoImpl.
//     */
//    @Test
//    public void testDeleteAllComments() {
//        User user = new User();
//        user.setUserName("userName");
//
//        user = userDao.createUser(user);
//
//        Post postToTest = new Post();
//        postToTest.setTitle("title");
//        postToTest.setCategory("category");
//        postToTest.setAddressString("address");
//        postToTest.setZipCode("zip");
//        postToTest.setPreview("preview");
//        postToTest.setEventInfo("eventInfo");
//        postToTest.setDateOfEvent(LocalDateTime.now().withNano(0));
//        postToTest.setUser(user);
//        postToTest = postDao.createPost(postToTest);
//
//        Comment comment = new Comment();
//        comment.setCommentText("comment");
//        comment.setCommentDate(LocalDateTime.now().withNano(0));
//        comment.setPostId(postToTest.getPostId());
//        comment = commentDao.createComment(comment);
//
//        //act
//        commentDao.deleteAllComments();
//
//        List<Comment> comments = commentDao.getAllComments();
//
//        assertTrue(comments.size() == 0);
//    }

}
