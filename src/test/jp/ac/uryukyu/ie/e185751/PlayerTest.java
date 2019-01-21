package jp.ac.uryukyu.ie.e185751;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
class PlayerTest {

    /**
     *  挟んで配置した時に相手の石を自分の石にできるか確認
     */
    @Test
    void change() {
        Board b = new Board(8);
        WhitePlayer wp = new WhitePlayer();
        BlackPlayer bp = new BlackPlayer();
        Comparator cp = new Comparator();

        bp.move(b,new Vector2(0,3)); //
        wp.move(b,new Vector2(0,4));
        b.display();
        Vector2 point = new Vector2(0,2);
        wp.move(b,point);
        wp.change(b,point);

        b.display();



    }

    /**
     * 挟んで配置した際に相手の石の座標を正しく返せるか確認
     */
    @Test
    void scan() {
        Board b = new Board(8);
        WhitePlayer wp = new WhitePlayer();
        BlackPlayer bp = new BlackPlayer();
        Comparator ca = new Comparator();

        //石を置く
        bp.move(b, new Vector2(3,3));
        bp.move(b, new Vector2(4,3));
        wp.move(b, new Vector2(5,3));

        //変えられる石の座標を返す
        ArrayList<Vector2> changeablePoints = wp.scan(new Vector2(2,3), b);

        //予測される答えを保存する
        ArrayList<Vector2> expect = new ArrayList<Vector2>();
        expect.add(new Vector2(3,3));
        expect.add(new Vector2(4,3));



        //比較する
        showTestContents(expect, changeablePoints);
        assertTrue(ca.compare(expect, changeablePoints));

        b = new Board(8);

        bp.move(b, new Vector2(4,3));
        wp.move(b, new Vector2(5,3));

        changeablePoints = wp.scan(new Vector2(2,3),b);

        expect = new ArrayList<Vector2>();

        showTestContents(expect, changeablePoints);

        assertTrue(ca.compare(expect,changeablePoints));

        b = new Board(8);
        bp.move(b,new Vector2(1,1));
        wp.move(b,new Vector2(0,0));
        bp.move(b,new Vector2(2,2));

        changeablePoints = wp.scan(new Vector2(3,3), b);

        expect = new ArrayList<Vector2>();
        expect.add(new Vector2(1,1));
        expect.add(new Vector2(2,2));

        showTestContents(expect, changeablePoints);

        assertTrue(ca.compare(expect,changeablePoints));

    }



    void showTestContents(ArrayList<Vector2> expect, ArrayList<Vector2> changeablePoints){
        System.out.println("想定");
        for (int i = 0; i < expect.size(); i++){
            System.out.println("[" + expect.get(i).x + " " + expect.get(i).y + "]");
        }
        System.out.println("実際");
        for (int i = 0; i < changeablePoints.size(); i++){
            System.out.println("[" + changeablePoints.get(i).x + " " + changeablePoints.get(i).y + "]");
        }
    }
}