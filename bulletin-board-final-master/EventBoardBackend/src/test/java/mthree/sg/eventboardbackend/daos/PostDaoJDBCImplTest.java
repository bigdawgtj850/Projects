/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.daos;

import java.time.LocalDate;
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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author stephenespinal
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostDaoJDBCImplTest {

    @Autowired
    PostDao postDao;

    @Autowired
    UserDao userDao;
    
    @Autowired
    CommentDao commentDao;

    public PostDaoJDBCImplTest() {
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
//     * Test of createPost method, of class PostDaoJDBCImpl.
//     */
//    @Test
//    public void testCreatePost() {
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
//        Post postFromDao = postDao.createPost(postToTest);
//
//        assertEquals(postFromDao, postToTest);
//    }
//
//    /**
//     * Test of getAllPosts method, of class PostDaoJDBCImpl.
//     */
//    @Test
//    public void testGetAllPosts() {
//        //arrange, act, assert
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
//        List<Post> posts = postDao.getAllPosts();
//
//        assertTrue(posts.contains(postToTest));
//        assertEquals(1, posts.size());
//
//    }
//
//    /**
//     * Test of getAllPostsByUserId method, of class PostDaoJDBCImpl.
//     */
//    @Test
//    public void testGetAllPostsByUserId() {
//        //arrange, act, assert
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
//        List<Post> posts = postDao.getAllPostsByUserId(postToTest.getUser().getUserId());
//
//        assertTrue(posts.contains(postToTest));
//        assertEquals(1, posts.size());
//
//    }
//
//    /**
//     * Test of getPostById method, of class PostDaoJDBCImpl.
//     */
//    @Test
//    public void testGetPostByPostId() {
//
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
//        Post postFromDao = postDao.getPostByPostId(postToTest.getPostId());
//
//        assertEquals(postToTest.getPostId(), postFromDao.getPostId());
//        assertEquals(postToTest.getUser().getUserName(), postFromDao.getUser().getUserName());
//        assertEquals(postToTest.getDateOfEvent(), postFromDao.getDateOfEvent());
//        assertEquals(postToTest, postFromDao);
//
//    }
//
//    /**
//     * Test of getPostById method, of class PostDaoJDBCImpl.
//     */
//    @Test
//    public void testGetPostByUserId() {
//
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
//        Post postFromDao = postDao.getPostByUserId(postToTest.getUser().getUserId());
//
//        assertEquals(postToTest.getUser().getUserName(), postFromDao.getUser().getUserName());
//        assertEquals(postToTest, postFromDao);
//
//    }
//
//    /**
//     * Test of updatePost method, of class PostDaoJDBCImpl.
//     */
//    @Test
//    public void testUpdatePost() {
//
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
//        //act
//        postToTest.setTitle("updated");
//        postDao.updatePost(postToTest);
//
//        Post postFromDao = postDao.getPostByPostId(postToTest.getPostId());
//
//        assertEquals(postFromDao.getTitle(), "updated");
//        assertEquals(postToTest, postFromDao);
//
//    }
//
//    /**
//     * Test of deletePostById method, of class PostDaoJDBCImpl.
//     */
//    @Test
//    public void testDeletePostById() throws EmptyResultDataAccessException {
//
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
//        postDao.deletePostById(postToTest.getPostId());
//
//        List<Post> posts = postDao.getAllPosts();
//
//        assertEquals(0, posts.size());
//
//        //we should expect the empty result exception from the sql command to be thrown here
//        try {
//            postDao.getPostByPostId(postToTest.getPostId());
//            //if we get here the test fails which is what we want to happen because it should be empty
//            fail("Expected EmptyResultException was not thrown.");
//        } catch (EmptyResultDataAccessException e) {
//            return;
//        }
//    }

}
