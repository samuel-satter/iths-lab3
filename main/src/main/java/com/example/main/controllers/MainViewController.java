package com.example.main.controllers;

import com.example.main.models.SquareModel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MainViewController {
    public Canvas canvas;

    public GraphicsContext context;

    public SquareModel square = new SquareModel();

    public void initialize(){
        context = canvas.getGraphicsContext2D();
    }

    public void onCanvasClicked(MouseEvent mouseEvent){
        context.setFill(Color.BLUE);
        context.fillRect(0, 0, 400, 400);
        context.setFill(Color.BLACK);
        context.fillRect(mouseEvent.getX()-(2.5), mouseEvent.getY()-(2.5), 5, 5);
    }
}
