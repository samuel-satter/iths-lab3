package com.example.main.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SquareModel extends ShapeModel{

    public SquareModel() {
        super();
    }


    @Override
    public void drawMe(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(getStartX(), getStartY(), getWidth(), getHeight());
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
    public ShapeModel createCopy(double startX, double startY, double width, double height) {
        return new SquareModel(startX, startY, width, height);
    }

    public SquareModel(double startX, double startY, double width, double height){
        super(startX, startY, width, height);
        this.setColor(Color.BLACK);
    }


}

