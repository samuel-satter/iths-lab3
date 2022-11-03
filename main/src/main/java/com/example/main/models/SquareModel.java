package com.example.main.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SquareModel extends ShapeModel{

    public SquareModel() {
        super();
    }


    @Override
    public void drawMe(GraphicsContext context, double startX, double startY, double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        context.setFill(getColor());
        context.fillRect(startX,startY,width,height);
    }

    @Override
    public void redrawMe(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(getStartX(), getStartY(), getWidth(), getHeight());
    }

    @Override
    public void changeMyColor(GraphicsContext context) {

    }

    @Override
    public void changeMySize(double x, double y) {

    }

    @Override
    public ShapeModel createCopy(double startX, double startY) {
        return new SquareModel(startX, startY);
    }

    public SquareModel(double startX, double startY){
        super(startX, startY);
        this.setColor(Color.BLACK);
    }


}

