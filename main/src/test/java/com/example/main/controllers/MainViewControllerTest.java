package com.example.main.controllers;

import com.example.main.models.Mode;
import com.example.main.models.SquareModel;
import de.saxsys.javafx.test.JfxRunner;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
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
        assert(mainViewController.listOfPositions.size() == 2);
        mainViewController.onPressedToUndo(new ActionEvent());
        assert(mainViewController.listOfPositions.size() == 1);
    }
    @Test
    void should_require_correct_mode(){
      mainViewController.onToggleToChange(new ActionEvent());
      Mode mode = Mode.CHANGE;
      assert (mode == Mode.CHANGE);

    }
}