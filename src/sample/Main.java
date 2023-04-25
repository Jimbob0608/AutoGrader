package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class Main extends Application {

    @FXML
    Button loginButton;
    TextField idTextField;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        /*
        loginButton.setOnAction(e -> {
            String text = idTextField.getText();
            sample.Application.ValidId(Long.parseLong(text));
        });
        */

        Button loginButton = (Button) root.lookup("#loginButton");
        TextField idTextField = (TextField) root.lookup("#idTextField");

        // Add an event handler to the loginButton
        loginButton.setOnAction(e -> {
            String text = idTextField.getText();
            long id = Long.parseLong(text);
            Person person = Application.ValidId(id);
            if (person != null) {
                // Do something with the Person object
            } else {
                // Handle the case where the ID is not valid
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}


