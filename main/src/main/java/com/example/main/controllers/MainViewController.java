package com.example.main.controllers;

import com.example.main.models.CircleModel;
import com.example.main.models.ShapeModel;
import com.example.main.models.SquareModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainViewController {

    public Canvas canvas;

    public Button squareButton;

    public Button circleButton;

    public Button lineButton;

    public Button ColorButton;

    public Button SizeButton;

    public ToggleButton toggleToChangeButton;

    public ToggleButton toggleToDrawButton;

    public TextField changeColorTextField;

    public TextField changeSizeTextField;

    private boolean isShapeSelected;

    private boolean isDrawMode;

    private ToggleGroup toggleGroup;

    private ShapeModel currentShape;

    public GraphicsContext context;

    private final SquareModel squareFactory = new SquareModel();

    private final CircleModel circleFactory = new CircleModel();

    List<ShapeModel> listOfPositions = new ArrayList<>();

    public void initialize() {
        context = canvas.getGraphicsContext2D();
        currentShape = squareFactory;
        toggleGroup = new ToggleGroup();
        toggleToDrawButton.setToggleGroup(toggleGroup);
        toggleToChangeButton.setToggleGroup(toggleGroup);
        changeColorTextField.setVisible(false);
        changeSizeTextField.setVisible(false);

    }


    @FXML
    public void onCircleButtonPress(ActionEvent buttonPressed) {
        currentShape = circleFactory;
        System.out.println("button pressed");
    }

    @FXML
    public void onSquareButtonPress(ActionEvent buttonPressed) {
        currentShape = squareFactory;
        System.out.println("button pressed");
    }

    @FXML
    public void onToggleToDraw(ActionEvent buttonPressed) {
        isDrawMode = true;
        changeColorTextField.setVisible(false);
        changeSizeTextField.setVisible(false);
        System.out.println("button pressed");
    }

    @FXML
    public void onToggleToChange(ActionEvent buttonPressed) {
        isDrawMode = false;
        System.out.println("button pressed");
    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        isShapeModelSelected(mouseEvent);
        if (isDrawMode) {
            ShapeModel shapeObject = currentShape.createCopy(mouseEvent.getX(), mouseEvent.getY(), 20, 20);
            listOfPositions.add(shapeObject);
            shapeObject.drawMe(context);
        } else if (isShapeModelSelected(mouseEvent).isEmpty()) {
            Alert errorMessage = new Alert(Alert.AlertType.ERROR);
            errorMessage.setHeaderText("Please select draw mode");
            errorMessage.show();
        }

    }


//    public void getMousePosition(MouseEvent mouseEvent, ){
//        if (mouseEvent.getX() == )
//
//    }

    @FXML
    public void onColorButtonPressed() {
        if (isDrawMode) {
            changeColorTextField.setVisible(false);
        } else {
            changeSizeTextField.setVisible(false);
            changeColorTextField.setVisible(true);
        }
    }

    @FXML
    public void onSizeButtonPressed(ActionEvent buttonPressed) {
        if (isDrawMode) {
            changeSizeTextField.setVisible(false);
        } else {
            changeColorTextField.setVisible(false);
            changeSizeTextField.setVisible(true);
        }
    }

    private boolean isHoveringOverShape(MouseEvent mouseEvent, ShapeModel shapeModel) {
        return mouseEvent.getX() >= shapeModel.getStartX() && mouseEvent.getX() <= shapeModel.getStartX() + 20
                && mouseEvent.getY() >= shapeModel.getStartY() && mouseEvent.getY() <= shapeModel.getStartY() + 20;
    }

    private Optional<ShapeModel> isShapeModelSelected(MouseEvent mouseEvent) {
        return listOfPositions.stream()
                .filter(shapeModel -> isHoveringOverShape(mouseEvent, shapeModel))
                .findAny();
    }

    public void onMouseHoverHighlightObject2(MouseEvent mouseEvent) {
        for (ShapeModel shapeModel : listOfPositions) {
            if (isHoveringOverShape(mouseEvent, shapeModel)) {
                shapeModel.setShapeSelected(true);
                System.out.println("found shape");
                Color color = shapeModel.getColor();
                shapeModel.setColor(Color.BLUEVIOLET);
                shapeModel.redrawMe(context);
                shapeModel.setColor(color);
            } else {
                shapeModel.setShapeSelected(false);
                shapeModel.redrawMe(context);
            }
        }

    }

    public void onMouseHoverHighlightObject(MouseEvent mouseEvent) {
        listOfPositions.forEach(shapeModel -> {
            isHoveringOverShape(mouseEvent, shapeModel);
            if (isHoveringOverShape(mouseEvent, shapeModel)) {
                shapeModel.setShapeSelected(true);
                System.out.println("found shape");
                Color color = shapeModel.getColor();
                shapeModel.setColor(Color.BLUEVIOLET);
                shapeModel.redrawMe(context);
                shapeModel.setColor(color);
            } else {
                shapeModel.setShapeSelected(false);
                shapeModel.redrawMe(context);
            }
        });
    }
}
