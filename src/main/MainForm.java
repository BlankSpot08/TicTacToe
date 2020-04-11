package main;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import start.GetNamesForm;

public class MainForm extends Application {
    private Label title;
    private Scene scene;
    private VBox vBox;
    private Button buttonStart;
    private Button buttonExit;
    private BorderPane borderPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        window.setScene(scene(window));
        window.setTitle("Tic Tac Toe");
        window.setResizable(false);
        window.getIcons().add(new Image("/icons/tic-tac-toe.png"));

        window.setOnCloseRequest(e -> {
            e.consume();

            closeProgram(window);
        });

        window.show();
    }

    public Scene scene(Stage window) {
        borderPane = new BorderPane();

        borderPane.setCenter(createVBox(window));
        borderPane.setTop(createTitle());

        scene = new Scene(borderPane, 400, 400);
        scene.getStylesheets().add("Choo.css");

        return scene;
    }

    private void closeProgram(Stage window) {
        AlertBox alertBox = new AlertBox(window.getX(), window.getY(), window.getHeight(), window.getWidth());

        BooleanProperty answer = alertBox.display("Exit Program", "Are you sure?");

        if (answer.getValue()) {
            window.close();
        }
    }

    private Label createTitle() {
        title = new Label("Tic Tac Toe");
        title.setFont(new Font("Arial", 50));
        BorderPane.setMargin(title, new Insets(50, 10, 10, 75));

        return title;
    }

    private VBox createVBox(Stage window) {
        buttonStart = new Button("Start");
        buttonStart.setId("MainButtons");
        buttonStart.setMinWidth(200);
        buttonStart.setMinHeight(50);

        buttonStart.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                GetNamesForm game = new GetNamesForm();

                window.setScene(game.scene(window));
            }
        });

        buttonStart.setOnAction(e -> {
            GetNamesForm game = new GetNamesForm();

            window.setScene(game.scene(window));
        });

        buttonExit = new Button("Exit Program");
        buttonExit.setMinWidth(200);
        buttonExit.setMinHeight(50);

        buttonExit.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                closeProgram(window);
            }
        });

        buttonExit.setOnAction(e -> {
            closeProgram(window);
        });

        vBox = new VBox(10);
        vBox.getChildren().addAll(buttonStart, buttonExit);
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }
}
