package com.game.snakeandladder.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Board {
    private int [][]arr;
    List<Snake> snakes;
    List<Ladder> ladders;
    Board(int n){
        arr = new int[n][n];
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }

    public void addSnake(int source, int destination){
        Snake snake = new Snake(source, destination);
        snakes.add(snake);
    }

    public void addLadder(int source, int destination){
        Ladder ladder = new Ladder(source, destination);
        ladders.add(ladder);
    }
}
