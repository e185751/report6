package jp.ac.uryukyu.ie.e185751;

public class Player {
    String color;
    String opponent_color;
    boolean isTurn;
    String name;
    String opponent_name;

    Player(String color, String opponent, String name, String opponent_name){
        this.color = color;
        this.opponent_color = opponent;
        this.isTurn = true;
        this.name = name;
        this.opponent_name = opponent_name;
    }

    public void move(Board board, Vector2 point){
        board.moved(this.color, point);
    }




}
