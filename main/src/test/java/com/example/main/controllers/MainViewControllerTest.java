package com.example.main.controllers;

import com.example.main.models.ShapeModel;
import com.example.main.models.SquareModel;
import de.saxsys.javafx.test.JfxRunner;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;

@RunWith(JfxRunner.class)
class MainViewControllerTest {
    MainViewController mainViewController;

    @BeforeEach
    void initialize(){
        mainViewController = new MainViewController();
        mainViewController.canvas = new Canvas();
        mainViewController.context = mainViewController.canvas.getGraphicsContext2D();

    }

    @Test
    void should_delete_last_position_in_list(){
        mainViewController.listOfPositions = new ArrayList<>();
        mainViewController.listOfPositions.add(new SquareModel());
        mainViewController.listOfPositions.add(new SquareModel());
        Assertions.assertEquals(2, mainViewController.listOfPositions.size());
        mainViewController.onPressedToUndo(new ActionEvent());
        Assertions.assertEquals(2, mainViewController.listOfPositions.size());
    }
    @Test
    void should_activate_when_over_square(){
        ShapeModel shapeModel = new SquareModel();
        ShapeModel shapeModelCopy = shapeModel.createCopy(0, 0 , 10, 10);
        Assertions.assertTrue(shapeModelCopy.isHoveringOver(5, 5));
    }
    @Test
    void should_not_activate_when_outside_square(){
        ShapeModel shapeModel = new SquareModel();
        ShapeModel shapeModelCopy = shapeModel.createCopy(0, 0 , 10, 10);
        Assertions.assertFalse(shapeModelCopy.isHoveringOver(200, 200));
    }

    @Test
    void should_activate_when_over_circle(){
        ShapeModel shapeModel = new SquareModel();
        ShapeModel shapeModelCopy = shapeModel.createCopy(0, 0 , 10, 10);
        Assertions.assertTrue(shapeModelCopy.isHoveringOver(5, 5));
    }
    @Test
    void should_not_activate_when_outside_circle(){
        ShapeModel shapeModel = new SquareModel();
        ShapeModel shapeModelCopy = shapeModel.createCopy(0, 0 , 10, 10);
        Assertions.assertFalse(shapeModelCopy.isHoveringOver(200, 200));
    }



}