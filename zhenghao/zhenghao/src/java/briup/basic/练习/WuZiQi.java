package java.briup.basic.练习;

/**
 * Created by ZH on 2016/2/3.
 */
public class WuZiQi {
    public static void main(String args[]){
        String[][] board = new String[15][15];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j] = "+";
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
