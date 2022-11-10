package com.example.main.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleModel extends ShapeModel {

    public CircleModel() {
    }

    @Override
    public void drawMe(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(getStartX(), getStartY(), getWidth(), getHeight());
    }

    @Override
    public void redrawMe(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(getStartX(), getStartY(), getWidth(), getHeight());
    }

    @Override
    public void deleteMe(GraphicsContext context, Color deleteColor) {
        context.setFill(deleteColor);
        context.fillOval(getStartX() - 1, getStartY() - 1, getWidth() + 5, getHeight() + 5);
    }

    @Override
    public ShapeModel createCopy(double startX, double startY, double width, double height) {
        return new CircleModel(startX, startY, width, height);
    }

    public CircleModel(double startX, double startY, double width, double height) {
        super(startX, startY, width, height);
        this.setColor(Color.BLUE);
    }

}
