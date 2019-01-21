package jp.ac.uryukyu.ie.e185751;

public class Board {
    String[][] boardData;
    int boardLength;

    Board(int boardLength){
        this.boardLength = boardLength;
        boardData = new String[this.boardLength][this.boardLength];
        makeBoardData();

    }

    public void makeBoardData(){
        for (int i = 0; i < boardLength; i++){
            for (int k = 0; k < boardLength; k++){
                boardData[k][i] = "*";
            }
        }
    }

    public void display(){
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

    public void moved(String color, Vector2 point){
        boardData[point.y][point.x] = color;
    }

    public void boardInitialize(){
        moved("○", new Vector2(3,3));
        moved("○", new Vector2(4,4));
        moved("●", new Vector2(3,4));
        moved("●", new Vector2(4,3));
    }
}
