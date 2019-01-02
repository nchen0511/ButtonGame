package sample;


import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;
import java.util.ArrayList;


public class BackEnd {
    public Button start;
    public Button score;

    public Button one;
    public Button two;
    public Button three;
    public Button four;

    public Label message;

    public boolean gameState;
    public boolean playing;
    public ArrayList<Integer> computerPattern = new ArrayList<>();
    public ArrayList<Integer> playerPattern = new ArrayList<>();

    public void startGame(ActionEvent actionEvent){
        start.setVisible(false);
        score.setVisible(false);
        start.setManaged(false);
        score.setManaged(false);

        one.setVisible(true);
        two.setVisible(true);
        three.setVisible(true);
        four.setVisible(true);

        one.setStyle("-fx-background-color:white");
        two.setStyle("-fx-background-color:white");
        three.setStyle("-fx-background-color:white");
        four.setStyle("-fx-background-color:white");

        gameState = true;
        runGame();
    }

    public void runGame(){
        final Timeline time = new Timeline();
        time.setCycleCount(time.INDEFINITE);
        computerPattern.add(1);
    }

    public void one(ActionEvent actionEvent){
        if(!playing){
            playerPattern.add(1);
        }
    }

    public void two(ActionEvent actionEvent){

    }

    public void showScore(ActionEvent actionEvent){
        start.setVisible(false);
        score.setVisible(false);
        start.setManaged(false);
        score.setManaged(false);
    }
}
