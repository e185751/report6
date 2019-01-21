package jp.ac.uryukyu.ie.e185751;
import java.util.ArrayList;

/**
 *  Playerクラス
 *  color: プレイヤーの持つ石データ
 *  opponent_color: 相手のプレイヤーの持つ石データ
 *  name: プレイヤーの名前
 *  opponent_name: 相手プレイヤーの名前
 *
 *  Created by e185751 on 2018/1/22
 */
public class Player {
    String color;
    String opponent_color;
    String name;
    String opponent_name;

    /***
     * コンストラクタ。自分の石データ、相手の石データ、自分の名前、相手の名前を指定する。
     * @param color
     * @param opponent
     * @param name
     * @param opponent_name
     */
    Player(String color, String opponent, String name, String opponent_name){
        this.color = color;
        this.opponent_color = opponent;
        this.name = name;
        this.opponent_name = opponent_name;
    }

    /***
     * boardに対して指定された座標で石をおく。
     * @param board 盤面
     * @param point 指定された座標
     */
    public void move(Board board, Vector2 point){
        board.moved(this.color, point);
    }


    /**
     * 何も置かれていない場所を一つずつ検証して、どの座標に石を置けるかを取得する。
     * @param b　盤面
     * @return ArrayList<Vector2>
     */
    public ArrayList<Vector2> getMovablePoints(Board b){
        ArrayList<Vector2> movablePoints = new ArrayList<Vector2>();
        for (Vector2 emptyPoint : b.emptyPoints){
            if (!scan(emptyPoint, b).isEmpty()){
                movablePoints.add(emptyPoint);
            }
        }
        return movablePoints;
    }

    /**
     * 置かれた座標から、相手の石を自分の石に変える。
     * @param b 盤面
     * @param point 置かれた座標
     */
    public void change(Board b, Vector2 point){
        ArrayList<Vector2> changeablePoints = scan(point, b);
        for (Vector2 changeablePoint : changeablePoints){
            move(b, changeablePoint);
        }
    }

    /**
     * 置かれた座標から、相手の石を自分の石に変えることができるような座標を取得する。
     * @param point　置かれた座標
     * @param b 盤面
     * @return ArrayList<Vector2>
     */
    public ArrayList<Vector2> scan(Vector2 point, Board b){

        ArrayList<Vector2> changeablePoints = new ArrayList<Vector2>();
        //全ての方角
        Vector2[] all_direction = {new Vector2(1,0), new Vector2(-1, 0), new Vector2(0,1), new Vector2(0,-1), new Vector2(1 ,1), new Vector2(1,-1), new Vector2(-1,-1), new Vector2(-1,1)};

        for (Vector2 direction : all_direction){
            for ( Vector2 changeablePoint : scanRay(point, b, direction)){
                changeablePoints.add(changeablePoint);
            }
        }

        return changeablePoints;
    }

    /**
     * 一つの方向に対して、自分の石に変えられるような座標を取得する。
     * @param point 置かれた座標
     * @param b 盤面
     * @param adjust 単位ベクトル
     * @return ArrayList<Vector2>
     */
    public ArrayList<Vector2> scanRay(Vector2 point, Board b, Vector2 adjust){
        ArrayList<Vector2> changeablePoints = new ArrayList<Vector2>();
        Vector2 scanFrame = point.add(adjust);

        while (0 <= scanFrame.x && scanFrame.x <= 7 && 0 <= scanFrame.y && scanFrame.y <= 7){
            if (b.getBoardData(scanFrame).equals("*")){
                break;
            }

            if (b.getBoardData(scanFrame).equals(opponent_color)){
                changeablePoints.add(scanFrame.copy());
            }

            if (b.getBoardData(scanFrame).equals(color)){
                return changeablePoints;
            }

            scanFrame = scanFrame.add(adjust);
        }

        changeablePoints.clear();

        return changeablePoints;
    }

    /**
     *
     * @param movablePoints
     * @param point
     * @return boolean
     */
    public boolean isMovable(ArrayList<Vector2> movablePoints, Vector2 point){
        for (Vector2 movablePoint : movablePoints){
            if (movablePoint.equals(point)){
                return true;
            }
        }
        return false;
    }



}
