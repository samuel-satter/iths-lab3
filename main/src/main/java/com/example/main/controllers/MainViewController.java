package com.example.main.controllers;

import com.example.main.models.CircleModel;
import com.example.main.models.Position;
import com.example.main.models.ShapeModel;
import com.example.main.models.SquareModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class MainViewController {

    public Canvas canvas;

    public Button squareButton;

    public Button circleButton;

    public Button lineButton;

    public Button ColorButton;

    public Button SizeButton;

    private ShapeModel shape;

    public GraphicsContext context;

    public SquareModel square = new SquareModel(20, Color.BLACK);

    public CircleModel circle = new CircleModel(20, 20, Color.BLACK);

    List<ShapeModel> listOfPositions = new ArrayList<>();

    public void initialize(){
        context = canvas.getGraphicsContext2D();

    }
    @FXML public void onCircleButtonPress(ActionEvent buttonPressed){
        shape = circle;
        System.out.println("button pressed");
    }

    @FXML public void onSquareButtonPress(ActionEvent buttonPressed){
//        ((Button)buttonPressed.getSource()).setOnAction();
        shape = square;
        System.out.println("button pressed");
    }

    public void onCanvasClicked(MouseEvent mouseEvent){
        shape.drawMe(context, mouseEvent.getX(), mouseEvent.getY());
    }

    public void getMousePosition(MouseEvent mouseEvent, ){
        if (mouseEvent.getX() == )

    }

    @FXML public void onColorButtonPressed(ActionEvent buttonPressed){
        shape =
    }

    @FXML public void onSizeButtonPressed(ActionEvent buttonPressed){

    }

    public void onShapeSelect(MouseEvent mouseEvent){

    }
}
