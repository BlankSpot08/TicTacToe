package User;

import javafx.beans.property.*;

public class User {
    public User(String turnSign) {
        name = new SimpleStringProperty(this, "name", "");
        score = new SimpleIntegerProperty(this, "score", 0);
        setUserChosen("");
        setTurn(false);
        setTurnSign(turnSign);
    }

    private StringProperty name;
    private IntegerProperty score;
    private boolean turn;
    private String turnSign;
    private String userChosen;

    public void setUserChosen(String userChosen) {
        this.userChosen = userChosen;
    }

    public String getUserChosen() {
        return this.userChosen;
    }

    public void setTurnSign(String turnSign) {
        this.turnSign = turnSign;
    }

    public String getTurnSign() {
        return turnSign;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean getTurn() {
        return turn;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getScore() {
        return score.get();
    }

    public IntegerProperty scoreProperty() {
        return score;
    }

    public void setScore(Integer score) {
        this.score.set(score);
    }
}
