package com.game.snakeandladder.services;

import java.util.List;
import java.util.Random;

import com.game.snakeandladder.models.Board;
import com.game.snakeandladder.models.Game;
import com.game.snakeandladder.models.Ladder;
import com.game.snakeandladder.models.Player;
import com.game.snakeandladder.models.Snake;

import lombok.Data;

@Data
public class GameService {
    private Game game;
    public GameService(Game game){
        this.game = game;
    }

    public void addSnakes(){
        game.getBoard().addSnake(9, 3);
        game.getBoard().addSnake(17, 7);
        game.getBoard().addSnake(89, 3);
        game.getBoard().addSnake(77, 33);
        game.getBoard().addSnake(63, 55);
        game.getBoard().addSnake(54, 12);
        game.getBoard().addSnake(46, 23);
        game.getBoard().addSnake(35, 24);
        game.getBoard().addSnake(19, 13);
        game.getBoard().addSnake(29, 13);
    }

    public void addLadders(){
        game.getBoard().addLadder(4, 24);
        game.getBoard().addLadder(14, 34);
        game.getBoard().addLadder(24, 44);
        game.getBoard().addLadder(34, 44);
        game.getBoard().addLadder(46, 64);
        game.getBoard().addLadder(52, 62);
        game.getBoard().addLadder(63, 73);
        game.getBoard().addLadder(76, 83);
        game.getBoard().addLadder(22, 24);
        game.getBoard().addLadder(12, 74);
    }

    public void checkSnakesAndLadder(Player player, Board board){
		List<Snake> snakes = board.getSnakes();
    	List<Ladder> ladders = board.getLadders();
		int currentPosition = player.getPosition();
		for(Snake snake: snakes){
			if(snake.getSource()==currentPosition){
				player.setPosition(snake.getDestination());
                System.out.println(player.getName()+" You got bit by a snake...hsssh!! "+ player.getPosition());
                return;
			}
		}
		for(Ladder ladder: ladders){
			if(ladder.getSource()==currentPosition){
				player.setPosition(ladder.getDestination());
                System.out.println(player.getName()+" Hurray you climbed a ladder!! " + player.getPosition());
                return;
			}
		}
	}

	public int getRandomNumber(Random rd){
		return 1 + rd.nextInt(6);
	}

    public void startGame(){
        Random rd = new Random();
        addLadders();
        addSnakes();
        Boolean player1flag = true;
		while(game.getPlayer1().getPosition()!=100 && game.getPlayer2().getPosition()!=100){
			Player currentPlayer;
			if(player1flag){
				System.out.println(game.getPlayer1().getName() + "'s Turn. Please roll the dice.");
				currentPlayer = game.getPlayer1();
			}else{
				System.out.println(game.getPlayer2().getName() + "'s Turn. Please roll the dice.");
				currentPlayer=game.getPlayer2();
			}
			player1flag = !player1flag;
			int dice = getRandomNumber(rd);
			if(currentPlayer.getPosition()==0 && dice!=6)continue;
			if(currentPlayer.getPosition()+dice>100)continue;
			currentPlayer.setPosition(currentPlayer.getPosition()+dice);
			System.out.println("CurrentPosition - " + currentPlayer.getPosition());
			checkSnakesAndLadder(currentPlayer, game.getBoard());
			if(currentPlayer.getPosition()==100){
				System.out.println(currentPlayer.getName()+" You have made it!!!");
				System.out.println("Game Over!!!");
			}
		}
    }

}
