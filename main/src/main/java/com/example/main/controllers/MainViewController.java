package com.example.main.controllers;

import com.example.main.models.CircleModel;
import com.example.main.models.ShapeModel;
import com.example.main.models.SquareModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MainViewController {

    public Canvas canvas;

    public Button squareButton;

    public Button circleButton;

    public Button lineButton;

    public Button ColorButton;

    public Button SizeButton;

    private ShapeModel currentShape;

    public GraphicsContext context;

    private final SquareModel squareFactory = new SquareModel();

    private final CircleModel circleFactory = new CircleModel();

    List<ShapeModel> listOfPositions = new ArrayList<>();

    public void initialize(){
        context = canvas.getGraphicsContext2D();
        currentShape = squareFactory;
    }

    @FXML public void onCircleButtonPress(ActionEvent buttonPressed){
        currentShape = circleFactory;
        System.out.println("button pressed");
    }

    @FXML public void onSquareButtonPress(ActionEvent buttonPressed){
        currentShape = squareFactory;
        System.out.println("button pressed");
    }

    public void onCanvasClicked(MouseEvent mouseEvent){
        ShapeModel shapeObject = currentShape.createCopy(mouseEvent.getX(), mouseEvent.getY());
        listOfPositions.add(shapeObject);
        shapeObject.drawMe(context, mouseEvent.getX(), mouseEvent.getY(), 20, 20);

    }


//    public void getMousePosition(MouseEvent mouseEvent, ){
//        if (mouseEvent.getX() == )
//
//    }

    @FXML public void onColorButtonPressed(ActionEvent buttonPressed){
    }

    @FXML public void onSizeButtonPressed(ActionEvent buttonPressed){

    }

    public void onMouseMoved(MouseEvent mouseEvent){
        for (ShapeModel shapeModel:listOfPositions){
            if ((mouseEvent.getX() >= shapeModel.getStartX() && mouseEvent.getX() <= shapeModel.getStartX() + 20)
            && mouseEvent.getY() >= shapeModel.getStartY() && mouseEvent.getY() <= shapeModel.getStartY() + 20){
                System.out.println("found shape");
                shapeModel.redrawMe(context);
            }
        }
    }
}
