package main;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlertBox {
    public AlertBox(double mainWindowXCoor, double mainWindowYCoor, double mainWindowHeight, double mainWindowWidth) {
        setMainWindowHeight(mainWindowHeight);
        setMainWindowWidth(mainWindowWidth);
        setMainWindowXCoor(mainWindowXCoor);
        setMainWindowYCoor(mainWindowYCoor);
        answer = new SimpleBooleanProperty(this, "answer", false);
    }

    private double mainWindowXCoor;
    private double mainWindowYCoor;
    private double mainWindowHeight;
    private double mainWindowWidth;

    private Stage window;
    private Label messageLabel;
    private Button yesButton;
    private Button noButton;
    private VBox vBox;
    private HBox hBox;
    private Scene scene;
    private BooleanProperty answer;

    public double getMainWindowHeight() {
        return mainWindowHeight;
    }

    public void setMainWindowHeight(double mainWindowHeight) {
        this.mainWindowHeight = mainWindowHeight;
    }

    public double getMainWindowWidth() {
        return mainWindowWidth;
    }

    public void setMainWindowWidth(double mainWindowWidth) {
        this.mainWindowWidth = mainWindowWidth;
    }

    public double getMainWindowYCoor() {
        return mainWindowYCoor;
    }

    public void setMainWindowYCoor(double mainWindowYCoor) {
        this.mainWindowYCoor = mainWindowYCoor;
    }

    public double getMainWindowXCoor() {
        return mainWindowXCoor;
    }

    public void setMainWindowXCoor(double mainWindowXCoor) {
        this.mainWindowXCoor = mainWindowXCoor;
    }

    private void setAnswer(boolean answer) {
        this.answer.set(answer);
    }

    public BooleanProperty display(String title, String message) {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);

        messageLabel = new Label(message);

        vBox.getChildren().addAll(messageLabel, createHBox());

        scene = new Scene(vBox, 250, 100);
        scene.getStylesheets().add("Choo.css");

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                setAnswer(false);
                window.close();
            }
        });

        window.setScene(scene);
        window.setResizable(false);
        window.initStyle(StageStyle.UNDECORATED);
        window.setX(getMainWindowXCoor() + (getMainWindowWidth() / 2) / 2);
        window.setY(getMainWindowYCoor() + (getMainWindowHeight() / 2) / 2);
        window.showAndWait();

        return answer;
    }

    private HBox createHBox() {
        hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);

        yesButton = new Button("Yes");
        yesButton.setPrefWidth(75);

        yesButton.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                setAnswer(true);
                window.close();
            }
        });

        yesButton.setOnAction(e -> {
            setAnswer(true);
            window.close();
        });

        noButton = new Button("No");
        noButton.setPrefWidth(75);

        noButton.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                setAnswer(false);
                window.close();
            }
        });

        noButton.setOnAction(e -> {
            setAnswer(false);
            window.close();
        });

        hBox.getChildren().addAll(yesButton, noButton);
        return hBox;
    }
}
