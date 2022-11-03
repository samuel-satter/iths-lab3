package com.example.main.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleModel extends ShapeModel{

    public CircleModel() {

    }


    @Override
    public void drawMe(GraphicsContext context, double startX, double startY, double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        context.setFill(getColor());
        context.fillOval(startX,startY,width,height);
    }

    @Override
    public void redrawMe(GraphicsContext context) {

    }

    @Override
    public void changeMyColor(GraphicsContext context) {

    }

    @Override
    public void changeMySize(double x, double y) {

    }

    @Override
    public ShapeModel createCopy(double startX, double startY) {
        return new CircleModel(startX, startY);
    }
    public CircleModel(double startX, double startY){
        super(startX, startY);
        this.setColor(Color.BLUE);
    }

    
}
