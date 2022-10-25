package com.example.main.models;

public class SquareModel {
    private Position position;

    public SquareModel(Position position){
        this.position = position;
    }

    public SquareModel(){
        this.position = new Position(19, 19);
    }
}
record Position(int x, int y){}
