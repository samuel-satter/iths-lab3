package com.example.main.models;

import javafx.scene.canvas.GraphicsContext;

public abstract class ShapeModel {

    public abstract void drawMe(GraphicsContext context, double x, double y);

    public abstract void changeMyColor(GraphicsContext context);

    public abstract void changeMySize(double x, double y);

}
