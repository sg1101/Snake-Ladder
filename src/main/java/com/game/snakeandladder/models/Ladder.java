package com.game.snakeandladder.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ladder {
    private int source;
    private int destination;
}
