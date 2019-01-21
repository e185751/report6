package jp.ac.uryukyu.ie.e185751;
import java.util.ArrayList;

/**
 * Boardクラス
 *  盤面情報を取り扱う。
 *   boardData: 盤面情報
 *   boardLength: 盤面の一辺の長さ
 *   emptyPoints: 何もない座標のリスト
 */
public class Board {
    String[][] boardData;
    int boardLength;
    ArrayList<Vector2> emptyPoints;

    /**
     * コンストラクタ。盤面の長さを取得する。
     * 盤面情報を生成し、空の座標をリスト化して保存する。
     * @param boardLength
     */
    Board(int boardLength){
        this.boardLength = boardLength;
        boardData = new String[this.boardLength][this.boardLength];
        makeBoardData();
        emptyPoints = new ArrayList<Vector2>();
        makeEmptyPoints();
    }

    /**
     * BoardDataを生成する。
     */
    public void makeBoardData(){
        for (int i = 0; i < boardLength; i++){
            for (int k = 0; k < boardLength; k++){
                boardData[k][i] = "*";
            }
        }
    }

    /**
     * emptyPointsを生成する。
     */
    public void makeEmptyPoints(){
        for (int i = 0; i < boardLength; i++){
            for (int k = 0; k < boardLength; k++){
                Vector2 point = new Vector2(k,i);
                emptyPoints.add(point);
            }
        }
    }

    /**
     * 盤面情報を表示する。
     */
    public void display(){
        System.out.println("");
        System.out.println("+ 0 1 2 3 4 5 6 7");
        for (int i = 0; i < boardLength; i++){
            String row = " ";
            for (int k = 0; k < boardLength; k++){
                row += boardData[i][k];
                row += " ";
            }
            System.out.println(i + row);
        }

    }

    /**
     * playerが置いた座標情報を取得して書き換える。
     * @param color playerの色
     * @param point 置かれた座標
     */
    public void moved(String color, Vector2 point){
        boardData[point.y][point.x] = color;
        removeEmptyPoint(point);
    }

    /**
     * 石を置かれた時に、emptyPointsからその座標を取り除くメソッド。
     * @param vec 置かれた座標
     */
    public void removeEmptyPoint(Vector2 vec){
        for (int i = 0; i < emptyPoints.size(); i++){
            if (emptyPoints.get(i).x == vec.x && emptyPoints.get(i).y == vec.y){
                emptyPoints.remove(i);
            }
        }
    }

    /**
     * 盤面情報を従来のオセロに合わせて初期化する。
     * @param wp
     * @param bp
     */
    public void boardInitialize(WhitePlayer wp, BlackPlayer bp){
        moved(wp.color, new Vector2(3,3));
        moved(wp.color, new Vector2(4,4));
        moved(bp.color, new Vector2(3,4));
        moved(bp.color, new Vector2(4,3));
    }

    /**
     * 指定された座標の盤面情報を返す。
     * @param point 指定された座標
     * @return String
     */
    public String getBoardData(Vector2 point){
        return this.boardData[point.y][point.x];
    }
}
