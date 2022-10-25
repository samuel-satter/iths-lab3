package com.example.main.models;

public class SquareModel {
    private Position position;
    private Direction direction;

    public SquareModel(Position position, Direction direction){
        this.position = position;
        this.direction = direction;
    }

    public SquareModel(){
        this.position = new Position(19, 19);
        this.direction = Direction.UP;
    }
}
record Position(int x, int y){}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}