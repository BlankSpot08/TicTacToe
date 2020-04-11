package start;

import User.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main.AlertBox;
import main.MainForm;

public class GameForm {
    public GameForm(User firstPlayer, User secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.firstPlayer.setTurn(true);
        this.secondPlayer.setTurn(false);
    }

    private User firstPlayer;
    private User secondPlayer;
    private Scene scene;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button backButton;
    private Button resetButton;
    private GridPane gridPane;
    private BorderPane borderPane;
    private BorderPane leftBorderPane;
    private BorderPane leftCenterPane;
    private BorderPane leftTopPane;
    private BorderPane centerBorderPane;
    private VBox vBox;
    private VBox bottomVBox;
    private Label firstPlayerNameLabel;
    private Label secondPlayerNameLabel;
    private Label titleLabel;
    private Label firstPlayerScoreLabel;
    private Label secondPlayerScoreLabel;
    private Label playerTurnLabel;

    public Scene scene(Stage window) {
        borderPane = new BorderPane();

        borderPane.setCenter(createCenterBorderPane(window));
        borderPane.setLeft(createLeftBorderPane(window));

        scene = new Scene(borderPane, 450, 400);
        scene.getStylesheets().add("Choo.css");

        return scene;
    }

    private BorderPane addLeftTop() {
        leftTopPane = new BorderPane();
        leftTopPane.setPadding(new Insets(10, 10, 0, 10));

        titleLabel = new Label();
        titleLabel.setText("Tic Tac Toe");
        titleLabel.setFont(Font.font("", FontWeight.BOLD, 20));
        titleLabel.setStyle("-fx-text-fill: #86C232");

        leftTopPane.setTop(titleLabel);

        return leftTopPane;
    }

    private VBox addLeftBottom(Stage window) {
        bottomVBox = new VBox(10);
        bottomVBox.setPadding(new Insets(0, 10, 46, 10));
        bottomVBox.setAlignment(Pos.BOTTOM_CENTER);

        backButton = new Button("Back");
        backButton.setPrefWidth(100);

        backButton.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                MainForm main = new MainForm();

                window.setScene(main.scene(window));
            }
        });

        backButton.setOnAction(e -> {
            MainForm main = new MainForm();

            window.setScene(main.scene(window));
        });

        resetButton = new Button("Reset");
        resetButton.setPrefWidth(100);

        resetButton.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                gameReset();
            }
        });

        resetButton.setOnAction(e -> {
            gameReset();
        });

        bottomVBox.getChildren().addAll(resetButton, backButton);

        return bottomVBox;
    }

    private BorderPane addLeftCenter() {
        leftCenterPane = new BorderPane();
        leftCenterPane.setPadding(new Insets(0, 10, 0, 10));

        vBox = new VBox(25);
        vBox.setPadding(new Insets(10, 10, 45, 10));
        vBox.setAlignment(Pos.CENTER_LEFT);

        firstPlayerNameLabel = new Label();
        firstPlayerNameLabel.setText(firstPlayer.getName());

        secondPlayerNameLabel = new Label();
        secondPlayerNameLabel.setText(secondPlayer.getName());

        firstPlayerScoreLabel = new Label("Score: "  + firstPlayer.getScore());
        secondPlayerScoreLabel = new Label("Score: " + secondPlayer.getScore());

        playerTurnLabel = new Label(firstPlayer.getName() + "'s Turn");
        playerTurnLabel.setStyle("-fx-text-fill: #61892F;");

        vBox.getChildren().addAll(firstPlayerNameLabel, firstPlayerScoreLabel, secondPlayerNameLabel, secondPlayerScoreLabel, playerTurnLabel);

        leftCenterPane.setCenter(vBox);

        return leftCenterPane;
    }

    private BorderPane createLeftBorderPane(Stage window) {
        leftBorderPane = new BorderPane();

        leftBorderPane.setTop(addLeftTop());
        leftBorderPane.setCenter(addLeftCenter());
        leftBorderPane.setBottom(addLeftBottom(window));
        return leftBorderPane;
    }

    private GridPane addCenterCenter(Stage window) {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        oneButton = new Button("");
        oneButton.setPrefWidth(100);
        oneButton.setPrefHeight(100);
        oneButton.setId("1");

        oneButton.setOnAction(e -> {
            playerTurn(oneButton, window);
        });

        twoButton = new Button("");
        twoButton.setPrefWidth(100);
        twoButton.setPrefHeight(100);
        twoButton.setId("2");

        twoButton.setOnAction(e -> {
            playerTurn(twoButton, window);
        });

        threeButton = new Button("");
        threeButton.setPrefWidth(100);
        threeButton.setPrefHeight(100);
        threeButton.setId("3");

        threeButton.setOnAction(e -> {
            playerTurn(threeButton, window);
        });

        fourButton = new Button("");
        fourButton.setPrefWidth(100);
        fourButton.setPrefHeight(100);
        fourButton.setId("4");

        fourButton.setOnAction(e -> {
            playerTurn(fourButton, window);
        });

        fiveButton = new Button("");
        fiveButton.setPrefWidth(100);
        fiveButton.setPrefHeight(100);
        fiveButton.setId("5");

        fiveButton.setOnAction(e -> {
            playerTurn(fiveButton, window);
        });

        sixButton = new Button("");
        sixButton.setPrefWidth(100);
        sixButton.setPrefHeight(100);
        sixButton.setId("6");

        sixButton.setOnAction(e -> {
            playerTurn(sixButton, window);
        });

        sevenButton = new Button("");
        sevenButton.setPrefWidth(100);
        sevenButton.setMinHeight(100);
        sevenButton.setId("7");

        sevenButton.setOnAction(e -> {
            playerTurn(sevenButton, window);
        });

        eightButton = new Button("");
        eightButton.setPrefWidth(100);
        eightButton.setPrefHeight(100);
        eightButton.setId("8");

        eightButton.setOnAction(e -> {
            playerTurn(eightButton, window);
        });

        nineButton = new Button("");
        nineButton.setPrefWidth(100);
        nineButton.setPrefHeight(100);
        nineButton.setId("9");

        nineButton.setOnAction(e -> {
            playerTurn(nineButton, window);
        });

        GridPane.setConstraints(oneButton, 0 , 0);
        GridPane.setConstraints(twoButton, 1 , 0);
        GridPane.setConstraints(threeButton, 2 , 0);
        GridPane.setConstraints(fourButton, 0 , 1);
        GridPane.setConstraints(fiveButton, 1 , 1);
        GridPane.setConstraints(sixButton, 2, 1);
        GridPane.setConstraints(sevenButton, 0 , 2);
        GridPane.setConstraints(eightButton, 1 , 2);
        GridPane.setConstraints(nineButton, 2 , 2);

        gridPane.getChildren().addAll(oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton);

        return gridPane;
    }

    private BorderPane createCenterBorderPane(Stage window) {
        centerBorderPane = new BorderPane();
        centerBorderPane.setLayoutX(100);

        centerBorderPane.setCenter(addCenterCenter(window));

        return centerBorderPane;
    }

    private void playerTurn(Button button, Stage window) {
        if (firstPlayer.getTurn()) {
            turn(button, firstPlayer, window);
            secondPlayer.setTurn(true);

            playerTurnLabel.setText(secondPlayer.getName() + "'s Turn");
        }

        else {
            turn(button, secondPlayer, window);
            firstPlayer.setTurn(true);

            playerTurnLabel.setText(firstPlayer.getName() + "'s Turn");
        }
    }

    private Button turn(Button button, User currentUser, Stage window) {
        currentUser.setUserChosen(currentUser.getUserChosen() + button.getId());
        currentUser.setTurn(false);

        button.setText(currentUser.getTurnSign());
        button.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
        button.setDisable(true);

        if (currentUser.getUserChosen().length() >= 3) {
            GameCheck gameCheck = new GameCheck();

            boolean didCurrentUserWon = gameCheck.check(currentUser);

            if (didCurrentUserWon) {
                won(currentUser, window);
            }
        }

        if (oneButton.isDisable() && twoButton.isDisable() && threeButton.isDisable() && fourButton.isDisable()
            && sixButton.isDisable() && sevenButton.isDisable() && eightButton.isDisable() && nineButton.isDisable()) {
            AlertBox alertBox = new AlertBox(window.getX(), window.getY(), window.getHeight(), window.getWidth());

            alertBox.display("Announcement", "Draw!!");

            gameReset();
        }

        return button;
    }

    private void won(User currentUser, Stage window) {
        currentUser.setScore(currentUser.getScore() + 1);

        AlertBox alertBox = new AlertBox(window.getX(), window.getY(), window.getHeight(), window.getWidth());

        alertBox.display("Announcement", "Congratulations!!! " + currentUser.getName() + " You won");

        firstPlayerScoreLabel.setText("Score: " + firstPlayer.getScore());
        secondPlayerScoreLabel.setText("Score: " + secondPlayer.getScore());

        gameReset();
    }

    private void gameReset() {
        oneButton.setText("");
        twoButton.setText("");
        threeButton.setText("");
        fourButton.setText("");
        fiveButton.setText("");
        sixButton.setText("");
        sevenButton.setText("");
        eightButton.setText("");
        nineButton.setText("");

        oneButton.setDisable(false);
        twoButton.setDisable(false);
        threeButton.setDisable(false);
        fourButton.setDisable(false);
        fiveButton.setDisable(false);
        sixButton.setDisable(false);
        sevenButton.setDisable(false);
        eightButton.setDisable(false);
        nineButton.setDisable(false);

        firstPlayer.setUserChosen("");
        secondPlayer.setUserChosen("");

        firstPlayer.setTurn(true);
        playerTurnLabel.setText(firstPlayer.getName() + "'s Turn");
        secondPlayer.setTurn(false);
    }
}
