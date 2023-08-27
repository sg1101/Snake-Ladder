package com.game.snakeandladder.models;

import lombok.Data;

@Data
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    public Game(int n){
        this.board = new Board(n);
    }
}
