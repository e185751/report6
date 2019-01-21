package jp.ac.uryukyu.ie.e185751;

/**
 * Vector2クラス
 *  ベクトルを扱う。
 *  x: x座標
 *  y: y座標
 */
public class Vector2 {
    int x,y;

    /**
     * コンストラクタ。
     * @param x 与えられるx座標
     * @param y 与えられるy座標
     */
    Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * 自分の持つx成分、y成分をvecのx成分、y成分とそれぞれ足し合わせ、その値を返す。
     * @param vec 自分に足し合わせたいベクトル
     * @return Vector2
     */
    public Vector2 getAdd(Vector2 vec){
        Vector2 result = new Vector2(this.x, this.y);
        result.x += vec.x;
        result.y += vec.y;
        return result;
    }

    /**
     * 自分の持つベクトルとvecが持つベクトルが同値か判断する。
     * @param vec 比較したいベクトル
     * @return boolean
     */
    public boolean equals(Vector2 vec){
        if (this.x == vec.x && this.y == vec.y){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 自分の持つx成分、y成分をvecのx成分、y成分とそれぞれ足し合わせ、その値を返す。
     * @param vec 自分に足し合わせたいベクトル
     * @return Vector2
     */
    public Vector2 add(Vector2 vec){
        return new Vector2(this.x + vec.x, this.y + vec.y);

    }

    /**
     * 自分の持つベクトルをコピーして返す。
     * @return Vector2
     */
    public Vector2 copy(){
        return new Vector2(this.x, this.y);
    }
}
