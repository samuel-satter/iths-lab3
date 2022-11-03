package com.example.main.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class ShapeModel {

    private double startX;

    private double startY;

    private double width;

    private double height;

    private Color color;

    public abstract void drawMe(GraphicsContext context, double startX, double startY, double width, double height);

    public abstract void redrawMe(GraphicsContext context);

    public abstract void changeMyColor(GraphicsContext context);

    public abstract void changeMySize(double x, double y);

    public abstract ShapeModel createCopy(double startX, double startY);

    public ShapeModel(){
    }


    public ShapeModel(double startX, double startY){
        this.startX = startX;
        this.startY = startY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
