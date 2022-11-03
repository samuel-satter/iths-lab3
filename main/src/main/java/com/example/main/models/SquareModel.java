package com.example.main.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SquareModel extends ShapeModel{

    private Color color;
    private double side;


    @Override
    public void drawMe(GraphicsContext context, double x, double y) {
        context.fillRect(x, y, side, side);
    }

    public SquareModel(double side, Color color){
        this.side = side;
        this.color = color;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
record Position(double x, double y){}
