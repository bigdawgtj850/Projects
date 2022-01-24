DROP DATABASE IF EXISTS GuessTheNumberDB;

CREATE DATABASE GuessTheNumberDB;

USE GuessTheNumberDB;

CREATE TABLE game (
	game_Id INT PRIMARY KEY AUTO_INCREMENT,
    answer char(4),
    finished BOOLEAN DEFAULT false
    );
    
INSERT INTO game(game_id, answer, finished) VALUES
	(1, "0314", true),
	(2, "3216", true),
	(3, "6108", true);

CREATE TABLE round (
	round_Id INT PRIMARY KEY AUTO_INCREMENT,
    game_id INT NOT NULL,
    guess_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    guess CHAR(4),
    result CHAR(7),
    FOREIGN KEY fk_gameid (game_id) REFERENCES game(game_id)
    );
    
    INSERT INTO round (round_Id, game_Id, guess_time, guess, result) VALUES 
    (1, 1, "2020-12-24 13:49:24", "6375", "e:1:p:1"),
    (2, 1, "2020-12-29 14:23:10", "1027", "e:3:p:1"),
    (3, 1, "2021-01-04 20:10:16", "0314", "e:2:p:2"),
    (4, 2, "2020-12:30 08:19:47", "3216", "e:2:p:3"),
    (5, 3, "2021-01-12 11:30:17", "1684", "e:0:p:0"),
    (6, 3, "2020-12-31 23:59:57", "6108", "e:3:p:1");
    
	select * from game;
    
    select * from round;