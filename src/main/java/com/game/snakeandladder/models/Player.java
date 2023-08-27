package com.game.snakeandladder.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private int position;
    public Player(String name){
        this.name = name;
        this.position = 0;
    }
}
