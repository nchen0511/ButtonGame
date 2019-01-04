package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;

import static sample.BackEnd.readScore;

public class GameCode extends Application {

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Simon Says");
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    public Button start;
    public Button score;

    public Button one;
    public Button two;
    public Button three;
    public Button four;

    public Label message;

    public boolean playing;
    public double tick = 0;
    public int points = 0;
    public int lastIndex = 0;
    public int index = 0;
    public ArrayList<Integer> pattern = new ArrayList<>();

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

        message.setText("Score: " + points);
        runGame();
    }

    public void runGame(){
        playing = false;
        message.setText("Score: " + points + "\nPay Attention");
        index = 0;
        for(int i=0;i<points+1;i++) {
            pattern.add((int) (Math.random() * 4) + 1);
        }

        AnimationTimer simon = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if(pattern.size()!=index) {
                    while(tick>0) {
                        tick=tick-0.1;
                    }
                    tick=100000000;

                    if(lastIndex==1){
                        one.setStyle("-fx-background-color:white");
                        lastIndex = 1;
                    } else if (lastIndex==2){
                        two.setStyle("-fx-background-color:white");
                        lastIndex = 2;
                    } else if (lastIndex==3) {
                        three.setStyle("-fx-background-color:white");
                        lastIndex = 3;
                    } else if (lastIndex==4) {
                        four.setStyle("-fx-background-color:white");
                        lastIndex = 4;
                    }

                    if(pattern.get(index)==1){
                        one.setStyle("-fx-background-color:red");
                        lastIndex = 1;
                    } else if (pattern.get(index)==2){
                        two.setStyle("-fx-background-color:red");
                        lastIndex = 2;
                    } else if (pattern.get(index)==3) {
                        three.setStyle("-fx-background-color:red");
                        lastIndex = 3;
                    } else if (pattern.get(index)==4) {
                        four.setStyle("-fx-background-color:red");
                        lastIndex = 4;
                    }

                    index++;
                } else {

                    while(tick>0) {
                        tick=tick-0.1;
                    }
                    if(lastIndex==1){
                        one.setStyle("-fx-background-color:white");
                        lastIndex = 1;
                    } else if (lastIndex==2){
                        two.setStyle("-fx-background-color:white");
                        lastIndex = 2;
                    } else if (lastIndex==3) {
                        three.setStyle("-fx-background-color:white");
                        lastIndex = 3;
                    } else if (lastIndex==4) {
                        four.setStyle("-fx-background-color:white");
                        lastIndex = 4;
                    }

                    playing = true;
                    message.setText("Score: " + points + "\nGo Ahead");
                    this.stop();
                }

            }
        };
        simon.start();
    }

    public void one(ActionEvent actionEvent){
        if(playing){
            if(pattern.get(0)==1){
                pattern.remove(0);
                if(pattern.size()==0){
                    addScore();
                    runGame();
                }
            } else {
                lose();
            }
        }
    }

    public void two(ActionEvent actionEvent){
        if(playing){
            if(pattern.get(0)==2){
                pattern.remove(0);
                if(pattern.size()==0){
                    addScore();
                    runGame();
                }
            } else {
                lose();
            }
        }
    }

    public void three(ActionEvent actionEvent){
        if(playing){
            if(pattern.get(0)==3){
                pattern.remove(0);
                if(pattern.size()==0){
                    addScore();
                    runGame();
                }
            } else {
                lose();
            }
        }
    }

    public void four(ActionEvent actionEvent){
        if(playing){
            if(pattern.get(0)==4){
                pattern.remove(0);
                if(pattern.size()==0){
                    addScore();
                    runGame();
                }
            } else {
                lose();
            }
        }
    }

    public void addScore(){
        points++;
        message.setText("Score: " + points + "\nGo Ahead");
    }

    public void lose(){
        message.setText("Game Over! Final Score: " + points);
        playing = false;
        start.setVisible(true);
        score.setVisible(true);
        start.setManaged(true);
        score.setManaged(true);
    }

    public void showScore(ActionEvent actionEvent){
        message.setText(readScore());
    }
}
