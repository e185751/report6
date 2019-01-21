package jp.ac.uryukyu.ie.e185751;

/**
 * BlackPlayerクラス
 *  Playerクラスより継承。
 *  自分の色を黒に。相手の色を白に指定する。
 */
public class BlackPlayer extends Player{
    /**
     * コンストラクタ。スーパークラスのコンストラクタにより自分の色を黒に、相手の色を白に指定する。
     */
    BlackPlayer(){ super("●", "○", "black", "white"); }
}
