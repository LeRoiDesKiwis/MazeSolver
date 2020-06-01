package com.override.tp.ms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.override.tp.ms.Case.CASE_SIZE;

public class Main extends Application {


    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) {
        Maze maze = new Maze();
        MazeSolver mazeSolver = new MazeSolver(maze);
        mazeSolver.solve();

        Scene scene = new Scene(maze, CASE_SIZE * 48, CASE_SIZE * 48);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
