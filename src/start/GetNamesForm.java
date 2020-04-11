package start;

import User.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.MainForm;

import static javafx.geometry.Pos.*;

public class GetNamesForm {
    private Scene scene;
    private Label firstPlayerLabel;
    private Label secondPlayerLabel;
    private TextField firstNameInput;
    private TextField secondNameInput;
    private Button buttonStart;
    private Button buttonBack;
    private GridPane gridPane;
    private BorderPane borderPane;
    private HBox hBox;

    public Scene scene(Stage window) {
        borderPane = new BorderPane();
        borderPane.setCenter(createGridPane(window));
        borderPane.setBottom(createHBox(window));

        scene = new Scene(borderPane, 400, 400);
        scene.getStylesheets().add("Choo.css");

        return scene;
    }

    private HBox createHBox(Stage window) {
        hBox = new HBox(10);
        hBox.setAlignment(CENTER);
        hBox.setPadding(new Insets(0, 0, 40, 0));

        buttonStart = new Button("Start");
        buttonStart.setMinWidth(100);

        buttonStart.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                choose(window);
            }
        });

        buttonStart.setOnAction(e -> {
            choose(window);
        });

        buttonBack = new Button("Back");
        buttonBack.setMinWidth(100);

        buttonBack.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                MainForm main = new MainForm();

                window.setScene(main.scene(window));
            }
        });

        buttonBack.setOnAction(e -> {
            MainForm main = new MainForm();

            window.setScene(main.scene(window));
        });

        hBox.getChildren().addAll(buttonStart, buttonBack);

        return hBox;
    }

    private GridPane createGridPane(Stage window) {
        gridPane = new GridPane();
        gridPane.setAlignment(CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        firstPlayerLabel = new Label("Player 1 Name: ");
        secondPlayerLabel = new Label("Player 2 Name: ");

        firstNameInput = new TextField();
        firstNameInput.setPromptText("Input name");

        firstNameInput.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                choose(window);
            }
        });

        secondNameInput = new TextField();
        secondNameInput.setPromptText("Input name");

        secondNameInput.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                choose(window);
            }
        });

        gridPane.add(firstPlayerLabel, 0, 0);
        gridPane.add(firstNameInput, 0, 1);
        gridPane.add(secondPlayerLabel, 1, 0);
        gridPane.add(secondNameInput, 1, 1);

        return gridPane;
    }

    public void choose(Stage window) {
        User firstPlayer = new User("X");
        User secondPlayer = new User("O");

        GameForm gameForm = new GameForm(firstPlayer, secondPlayer);

        getName(firstPlayer, "Player 1", firstNameInput);

        getName(secondPlayer, "Player 2", secondNameInput);

        window.setScene(gameForm.scene(window));
    }

    public void getName(User player, String whichPlayer, TextField inputName) {
        if (inputName.getText().length() != 0) {
            if (inputName.getText().length() >= 16) {
                player.setName(inputName.getText().substring(0, 16));
            }
            else {
                player.setName(inputName.getText());
            }
        }
        else {
            player.setName(whichPlayer);
        }
    }
}
