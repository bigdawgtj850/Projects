

package com.sg.guessthenumber.service;

import com.sg.guessthenumber.TestApplicationConfiguration;
import com.sg.guessthenumber.dao.GameDao;
import com.sg.guessthenumber.entity.Game;
import java.util.List;
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
 * @author ShantelJ
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {

    @Autowired
    ServiceLayer service;
    
    @Autowired
    GameDao gameDao;

    public ServiceLayerTest() {
    }
    
    @Before
    public void setUp() {
        List<Game> games = service.getAllGames();
        for (Game game : games) {
            service.deleteGame(game.getGameId());
        }
    }

    @Test
    public void testDetermineResult1() {
        String guess = "1234";
        String answer = "2159";
        String result = service.determineResult(guess, answer);

        assertEquals("e:0:p:2", result);
    }

    @Test
    public void testDetermineResult2() {
        String guess = "1234";
        String answer = "1234";
        String result = service.determineResult(guess, answer);

        assertEquals("e:4:p:0", result);
    }

    @Test
    public void testDetermineResult3() {
        String guess = "1234";
        String answer = "4321";
        String result = service.determineResult(guess, answer);

        assertEquals("e:0:p:4", result);
    }

    @Test
    public void testDetermineResult4() {
        String guess = "1234";
        String answer = "1324";
        String result = service.determineResult(guess, answer);

        assertEquals("e:2:p:2", result);
    }

    @Test
    public void testDetermineResult5() {
        String guess = "1234";
        String answer = "5678";
        String result = service.determineResult(guess, answer);

        assertEquals("e:0:p:0", result);
    }   

}
