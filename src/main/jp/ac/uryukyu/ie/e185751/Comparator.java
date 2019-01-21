package jp.ac.uryukyu.ie.e185751;
import java.util.ArrayList;

/**
 * Compratorクラス
 *  二重リストの比較に使う
 */
public class Comparator {
    Comparator(){

    }

    /**
     * 二重リストを比較する。要素が同じであればtrueを返し、そうでなければfalseを返す。
     * @param listA 一つめのリスト
     * @param listB 二つ目のリスト
     * @return boolean
     */
    public boolean compare(ArrayList<Vector2> listA, ArrayList<Vector2> listB){
        int sum = 0;
        if (!(listA.size() == listB.size())){
            return false;
        }
        else {
            for (int i = 0; i < listA.size(); i++) {
                for (int k = 0; k < listB.size(); k++){
                    if (listA.get(i).equals((listB.get(k)))){
                        sum += 1;
                    }
                }
            }
        }
        if (sum == listA.size()){
            return true;
        }
        else{
            return false;
        }
    }


}
