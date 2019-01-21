package jp.ac.uryukyu.ie.e185751;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Board b = new Board(8);
        b.boardInitialize();
        b.display();


        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Vector2 point = new Vector2(x,y);


        WhitePlayer wp = new WhitePlayer();
        wp.move(b, point);

        b.display();
    }
}
