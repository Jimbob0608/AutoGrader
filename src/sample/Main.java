package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    // A boolean to represent whether a user has uploaded the inputted file.
    boolean uploaded = true;

    // A boolean to represent whether a login error has been given to the user.
    private boolean alerted = false;

    // A long integer to represent the id of the current user.
    private long id;

    // Strings to represent the file paths of various resources required.
    private String perfectSubmission = "C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\sample\\Resources\\perfect-submission-example";
    private String failSubmission = "C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\sample\\Resources\\fail-submission-example";
    private String newSubmission = "C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\sample\\Resources\\new-submission-example";

    /**
     * This method starts the program and handles FXML implementation.
     *
     * @param primaryStage this is the stage which will hold the login page.
     * @throws IOException is the exception to be caught should the FXML fail.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        //Create login page.
        Parent root = FXMLLoader.load(getClass().getResource("loginTab.fxml"));
        primaryStage.setTitle("AutoGrader by Jamie Jay Haughton/2007483");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
        Button loginButton = (Button) root.lookup("#loginButton");
        TextField idTextField = (TextField) root.lookup("#idTextField");
        //Set login button functionality to check id validity.
        loginButton.setOnAction(e -> {
            String text = idTextField.getText();
            if (text.length() > 0) {
                id = Long.parseLong(text);
            } else {
                alerted = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid ID");
                alert.setHeaderText(null);
                alert.setContentText("The entered ID is not valid.");
                alert.showAndWait();
            }
            FileProcessor fileProcessor = new FileProcessor();
            Person person = fileProcessor.ValidId(id);
            //If the id is valid then transition to relevant page.
            if (person != null) {
                Stage newStage = new Stage();
                Parent newRoot = null;
                try {
                    //Transition to Student tab.
                    if (person.isTeacher == false) {
                        newRoot = FXMLLoader.load(getClass().getResource("studentTab.fxml"));
                        Label studentWecomeMessage = (Label) newRoot.lookup("#studentWelcomeMessage");
                        studentWecomeMessage.setText("Welcome " + person.getName() + "!");
                        Button submissionOneButton = (Button) newRoot.lookup("#SubmissionOneButton");
                        Button submissionTwoButton = (Button) newRoot.lookup("#SubmissionTwoButton");
                        Button uploadButton = (Button) newRoot.lookup("#UploadButton");
                        Button submitButton = (Button) newRoot.lookup("#SubmitButton");
                        Label percentageLabel = (Label) newRoot.lookup("#PercentageLabel");
                        Label markLabel = (Label) newRoot.lookup("#MarkLabel");
                        //Create button functionality for the Student tab.
                        if (person.getName().equals("Stu Dent")) {
                            uploadButton.setOnAction(event -> {
                                if (uploaded == true) {
                                    submitButton.setDisable(false);
                                    uploadButton.setDisable(true);
                                    submitButton.setText("SUBMIT ASSIGNMENT");
                                }
                            });
                            submitButton.setOnAction(event -> {
                                uploadButton.setDisable(false);
                                submitButton.setDisable(true);
                                submissionTwoButton.setDisable(false);
                                submissionTwoButton.setText("CS456 Submission");
                                submitButton.setText("Upload file to submit.");
                                uploaded = false;
                            });
                        }
                        submissionOneButton.setOnAction(event -> {
                            int mark;
                            if (person.getName().equals("Stu Dent")) {
                                mark = fileProcessor.submissionCalculator(perfectSubmission);
                            } else {
                                mark = fileProcessor.submissionCalculator(failSubmission);
                            }
                            String markString = String.valueOf(mark);
                            String percentageString = String.valueOf(fileProcessor.submissionPercentageCalculator(mark,
                                    fileProcessor.markSchemeSize()));
                            percentageLabel.setText(percentageString + "%");
                            markLabel.setText(markString + "/" + fileProcessor.markSchemeSize());
                        });
                        submissionTwoButton.setOnAction(event -> {
                            int mark = fileProcessor.submissionCalculator(newSubmission);
                            String markString = String.valueOf(mark);
                            String percentageString = String.valueOf(fileProcessor.submissionPercentageCalculator(mark,
                                    fileProcessor.markSchemeSize()));
                            percentageLabel.setText(percentageString + "%");
                            markLabel.setText(markString + "/" + fileProcessor.markSchemeSize());
                        });
                        // Transition to teacher tab.
                    } else if (person.isTeacher) {
                        newRoot = FXMLLoader.load(getClass().getResource("teacherTab.fxml"));
                        Label teacherWecomeMessage = (Label) newRoot.lookup("#teacherWelcomeMessage");
                        teacherWecomeMessage.setText("Welcome " + person.getName() + "!");
                        Button stuDentButton = (Button) newRoot.lookup("#StuDentButton");
                        Button leahNerButton = (Button) newRoot.lookup("#LeahNerButton");
                        Label percentageLabel = (Label) newRoot.lookup("#PercentageLabel");
                        Label markLabel = (Label) newRoot.lookup("#MarkLabel");
                        //Set button functionality for teacher tab.
                        stuDentButton.setOnAction(event -> {
                            int mark = fileProcessor.submissionCalculator(perfectSubmission);
                            String markString = String.valueOf(mark);
                            String percentageString = String.valueOf(fileProcessor.submissionPercentageCalculator(mark,
                                    fileProcessor.markSchemeSize()));
                            percentageLabel.setText(percentageString + "%");
                            markLabel.setText(markString + "/" + fileProcessor.markSchemeSize());
                        });
                        leahNerButton.setOnAction(event -> {
                            int mark = fileProcessor.submissionCalculator(failSubmission);
                            String markString = String.valueOf(mark);
                            String percentageString = String.valueOf(fileProcessor.submissionPercentageCalculator(mark,
                                    fileProcessor.markSchemeSize()));
                            percentageLabel.setText(percentageString + "%");
                            markLabel.setText(markString + "/" + fileProcessor.markSchemeSize());
                        });
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                //Set parameters for the previously specified tab/scene.
                newStage.setTitle("AutoGrader - " + person.getName());
                newStage.setScene(new Scene(newRoot, 300, 400));
                newStage.show();
                // Close the existing window
                Stage currentStage = (Stage) loginButton.getScene().getWindow();
                currentStage.close();
            } else if (!alerted) {
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
     * The main entry point for the application. Launches the JavaFX application by calling
     * the launch() method with the given arguments.
     * @param args an array of command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}