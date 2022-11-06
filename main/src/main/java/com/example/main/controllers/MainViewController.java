package com.example.main.controllers;

import com.example.main.models.CircleModel;
import com.example.main.models.Mode;
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
import java.util.Collection;
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

    public TextField changeSizeTextField;

    public javafx.scene.control.ColorPicker ColorPicker;

    public Button deleteButton;

    private Mode mode;

    private boolean isChangingColor;

    private boolean isDrawMode;

    private ShapeModel currentShape;

    public GraphicsContext context;

    private final SquareModel squareFactory = new SquareModel();

    private final CircleModel circleFactory = new CircleModel();

    List<ShapeModel> listOfPositions = new ArrayList<>();

    public void initialize() {
        context = canvas.getGraphicsContext2D();
        currentShape = squareFactory;
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleToDrawButton.setToggleGroup(toggleGroup);
        toggleToChangeButton.setToggleGroup(toggleGroup);
        ColorPicker.setVisible(false);
        changeSizeTextField.setVisible(false);
        isChangingColor = true;
        mode = Mode.DRAW;
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
        mode = Mode.DRAW;
        ColorPicker.setVisible(false);
        changeSizeTextField.setVisible(false);
        System.out.println("button pressed");
    }

    @FXML
    public void onToggleToChange(ActionEvent buttonPressed) {
        mode = Mode.CHANGE;
        System.out.println("button pressed");
    }

    @FXML
    public void onToggleToDelete(ActionEvent buttonPressed) {
        mode = Mode.DELETE;
        ColorPicker.setVisible(false);
        changeSizeTextField.setVisible(false);
        System.out.println("button pressed");
    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        getSelectedShapeModel(mouseEvent);
        if (mode == Mode.DRAW) {
            ShapeModel shapeObject = currentShape.createCopy(mouseEvent.getX(), mouseEvent.getY(), 20, 20);
            listOfPositions.add(shapeObject);
            shapeObject.drawMe(context);
        } else if (getSelectedShapeModel(mouseEvent).isEmpty()) {
            Alert errorMessage = new Alert(Alert.AlertType.ERROR);
            errorMessage.setHeaderText("Please select draw mode");
            errorMessage.show();
        } else {
            if (mode == Mode.CHANGE && isChangingColor) {
                selectShapeToChangeColorOf(mouseEvent);
            } else if (mode == Mode.DELETE){
                selectShapeToDelete(mouseEvent);
            } else {
                selectShapeToChangeSizeOf(mouseEvent);
            }
        }

    }
    public void selectShapeToDelete(MouseEvent mouseEvent){
        Optional<ShapeModel> optionalShapeModel = getSelectedShapeModel(mouseEvent);
        optionalShapeModel.ifPresent(shapeModel -> {
            shapeModel.deleteMe(context, Color.WHITE);
            listOfPositions.remove(shapeModel);
        });

    }

    public void selectShapeToChangeSizeOf(MouseEvent mouseEvent) {
        if (mode != Mode.DRAW) {
            int newSize = Integer.parseInt(changeSizeTextField.getText());
            Optional<ShapeModel> optionalShapeModel = getSelectedShapeModel(mouseEvent);
            optionalShapeModel.ifPresent(shapeModel -> {
                shapeModel.deleteMe(context, Color.WHITE);
                shapeModel.setHeight(newSize);
                shapeModel.setWidth(newSize);
                shapeModel.drawMe(context);
            });
        }
    }

    public void selectShapeToChangeColorOf(MouseEvent mouseEvent) {
        if (mode != Mode.DRAW) {
            Optional<ShapeModel> optionalShapeModel = getSelectedShapeModel(mouseEvent);
            optionalShapeModel.ifPresent(model -> model.setColor(ColorPicker.getValue()));
        }
    }

    @FXML
    public void onColorButtonPressed() {
        isChangingColor = true;
        if (mode == Mode.DRAW) {
            ColorPicker.setVisible(false);
        } else {
            changeSizeTextField.setVisible(false);
            ColorPicker.setVisible(true);
        }
    }

    @FXML
    public void onSizeButtonPressed(ActionEvent buttonPressed) {
        isChangingColor = false;
        if (mode == Mode.DRAW) {
            changeSizeTextField.setVisible(false);
        } else {
            ColorPicker.setVisible(false);
            changeSizeTextField.setVisible(true);
        }
    }

    private boolean isHoveringOverShape(MouseEvent mouseEvent, ShapeModel shapeModel) {
        return mouseEvent.getX() >= shapeModel.getStartX() && mouseEvent.getX() <= shapeModel.getStartX() + shapeModel.getWidth()
                && mouseEvent.getY() >= shapeModel.getStartY() && mouseEvent.getY() <= shapeModel.getStartY() + shapeModel.getHeight();
    }

    private Optional<ShapeModel> getSelectedShapeModel(MouseEvent mouseEvent) {
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
