package com.example.main.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleModel extends ShapeModel{

    private Color color;

    private double width;
    
    private double height;

    @Override
    public void drawMe(GraphicsContext context, double x, double y) {
        context.fillOval(x, y, width, height);
    }

    public CircleModel(double width, double height, Color color){
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
}
