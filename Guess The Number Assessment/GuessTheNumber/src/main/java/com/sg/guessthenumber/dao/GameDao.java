
package com.sg.guessthenumber.dao;

import com.sg.guessthenumber.entity.Game;
import java.util.List;

/**
 *
 * @author ShantelJ
 */

public interface GameDao {
    List<Game> getAllGames();
    Game getGameById(int gameId);
    Game addGame(Game game);
    void updateGame(Game round);
    void deleteGame(int gameId);
   }
