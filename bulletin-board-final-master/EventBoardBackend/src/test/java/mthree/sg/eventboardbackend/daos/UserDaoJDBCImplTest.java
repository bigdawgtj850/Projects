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
public class UserDaoJDBCImplTest {

    @Autowired
    UserDao userDao;

    @Autowired
    PostDao postDao;

    @Autowired
    CommentDao commentDao;

    public UserDaoJDBCImplTest() {
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
//     * Test of createUser method, of class UserDaoJDBCImpl.
//     */
//    @Test
//    public void testCreateUser() {
//
//        //arrange, act, assert
//        //create post to test creation
//        User user = new User();
//        user.setUserName("userName");
//
//        User createdUser = userDao.createUser(user);
//
//        assertEquals(user, createdUser);
//
//    }
//
//    /**
//     * Test of getAllUsers method, of class UserDaoJDBCImpl.
//     */
//    @Test
//    public void testGetAllUsers() {
//        User user = new User();
//        user.setUserName("userName");
//
//        user = userDao.createUser(user);
//
//        User user2 = new User();
//        user2.setUserName("userName");
//
//        user2 = userDao.createUser(user2);
//
//        List<User> users = userDao.getAllUsers();
//
//        assertTrue(users.contains(user));
//
//    }
//
//    /**
//     * Test of getUserById method, of class UserDaoJDBCImpl.
//     */
//    @Test
//    public void testGetUserById() {
//        User user = new User();
//        user.setUserName("userName");
//
//        user = userDao.createUser(user);
//
//        User userFromDao = userDao.getUserById(user.getUserId());
//
//        assertEquals(user, userFromDao);
//    }
//
//    /**
//     * Test of updateUser method, of class UserDaoJDBCImpl.
//     */
//    @Test
//    public void testUpdateUser() {
//        User user = new User();
//        user.setUserName("userName");
//
//        user = userDao.createUser(user);
//
//        //act
//        user.setUserName("updated");
//        userDao.updateUser(user);
//
//        User userFromDao = userDao.getUserById(user.getUserId());
//
//        assertEquals("updated", userFromDao.getUserName());
//
//    }
//
//    /**
//     * Test of deleteUserById method, of class UserDaoJDBCImpl.
//     */
//    @Test
//    public void testDeleteUserById() {
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
//        userDao.deleteUserById(user.getUserId());
//
//        List<User> users = userDao.getAllUsers();
//
//        assertTrue(users.size() == 0);
//    }
//
//    /**
//     * Test of deleteAllUsers method, of class UserDaoJDBCImpl.
//     */
//    @Test
//    public void testDeleteAllUsers() {
//        User user = new User();
//        user.setUserName("userName");
//
//        user = userDao.createUser(user);
//
//        //act
//        userDao.deleteAllUsers();
//
//        List<User> users = userDao.getAllUsers();
//
//        assertTrue(users.size() == 0);
//    }

}
