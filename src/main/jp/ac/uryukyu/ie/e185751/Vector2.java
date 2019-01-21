package jp.ac.uryukyu.ie.e185751;

public class Vector2 {
    int x,y;
    Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Vector2 getAdd(Vector2 vec){
        Vector2 result = new Vector2(this.x, this.y);
        result.x += vec.x;
        result.y += vec.y;
        return result;
    }
}
