package jp.ac.uryukyu.ie.e185751;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Board b = new Board(8);
        WhitePlayer wp = new WhitePlayer();
        BlackPlayer bp = new BlackPlayer();
        b.boardInitialize(wp, bp);
        b.display();
        int endFlag = 0;
        boolean whiteTurn = true;


        Scanner sc = new Scanner(System.in);
        Player p;




    }

}
