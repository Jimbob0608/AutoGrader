package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    @FXML
    Button loginButton;
    TextField idTextField;
    private boolean alerted = false;
    private long id;

    /***
     *
     * @param primaryStage
     * @throws Exception
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loginTab.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();

        Button loginButton = (Button) root.lookup("#loginButton");
        TextField idTextField = (TextField) root.lookup("#idTextField");

        // Add an event handler to the loginButton
        // Add an event handler to the loginButton
        loginButton.setOnAction(e -> {
            String text = idTextField.getText();
            if(text.length() > 0) {
                id = Long.parseLong(text);
            } else {
                alerted = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid ID");
                alert.setHeaderText(null);
                alert.setContentText("The entered ID is not valid.");
                alert.showAndWait();
            }
            //Person person = Application.ValidId(id);
            Person person = new Person(31, "Mariah", true);
            if (person != null) {
                // Create a new window
                Stage newStage = new Stage();
                Parent newRoot = null;
                try {
                    if (!person.isTeacher) {
                        newRoot = FXMLLoader.load(getClass().getResource("studentTab.fxml"));
                    } else if (person.isTeacher) {
                        newRoot = FXMLLoader.load(getClass().getResource("teacherTab.fxml"));
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                newStage.setTitle("New Window");
                newStage.setScene(new Scene(newRoot, 300, 400));
                newStage.show();

                // Close the existing window
                Stage currentStage = (Stage) loginButton.getScene().getWindow();
                currentStage.close();
            } else if (!alerted){
                // Handle the case where the ID is not valid
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid ID");
                alert.setHeaderText(null);
                alert.setContentText("The entered ID does not exist.");
                alert.showAndWait();
            }
        });
    }

    /***
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}


