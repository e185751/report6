package jp.ac.uryukyu.ie.e185751;

/**
 * WhitePlayerクラス。
 *  Playerクラスより継承。
 *  自分の色を白に、相手の色を黒に指定する。
 *
 */
public class WhitePlayer extends Player{
    /**
     * コンストラクタ。superクラスのコンストラクタより、自分の色を白に、相手の色を黒にそれぞれ指定する。
     */
    WhitePlayer(){ super("○", "●", "white", "black");}
}
