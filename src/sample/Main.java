package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static sample.BackEnd.generateCsvFile;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Fast Clicker");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        generateCsvFile("highScores.csv","24","15","1");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
