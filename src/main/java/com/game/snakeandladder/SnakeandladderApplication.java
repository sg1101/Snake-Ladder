package com.game.snakeandladder;
import java.util.Random;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.game.snakeandladder.models.Game;
import com.game.snakeandladder.models.Player;
import com.game.snakeandladder.services.GameService;

@SpringBootApplication
public class SnakeandladderApplication {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to a Snake&Ladder Game!!");
		int dimension = 10;
		Game game = new Game(dimension);
		System.out.println("Please input the name of the first player");
		game.setPlayer1(new Player(sc.nextLine()));
		System.out.println("Please input the name of the second player");
		game.setPlayer2(new Player(sc.nextLine()));
		GameService gameService = new GameService(game);
		System.out.println("let us start the game");
		gameService.startGame();
	}

}
