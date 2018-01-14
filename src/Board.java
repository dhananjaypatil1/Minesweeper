import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

/**
 * Board Class
 * Contains the game board int form of Strings representing three values
 * S: Safe Tile
 * Number : Number of adjacent Danger Tiles
 * D: Danger Tile
 */
public class Board {
    public String[][] board;
    public int row;
    public int col;
    int difficulty;
    int countBombs=0;
   // public HashSet<Pos> remaining = new HashSet<>();

    public Board(int length, int width, int difficulty){
        row=length;
        col=width;
        this.difficulty=difficulty;
        board = new String[length][width];
        fillUpBoard();
        addBombs(difficulty);
        //printBoard();
    }

    /**
     * Fill Up Board with all safe tiles
     */
    private void fillUpBoard(){
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = "S";
            }
        }

    }
    private void addBombs(int num){
        Random x = new Random();
        while (num>0){
            int r = x.nextInt(row);
            int c = x.nextInt(col);
            board[r][c]="D";
            addCount(r,c);
            num--;
        }

    }
    private void addCount(int r, int c){
        for(int i=r-1;i<=r+1;i++){
            for(int j=c-1;j<=c+1;j++){
                if((i>=0 && j>=0)&&(i<row && j<col)&&(board[i][j]!="D")){
                    if(board[i][j]=="S"){
                        board[i][j] = "1";
                    }
                    else{
                        board[i][j] = Integer.toString(Integer.parseInt(board[i][j]) +1);
                    }
                   // remaining.add(new Pos(i,j));
                }
                else{
                    countBombs++;
                }

            }

        }
    }

    public void printBoard(){

        for(int r=0;r < board.length;r++){
            System.out.print("|");
            for(int c=0;c< board[0].length;c++){
                System.out.print("  "+board[r][c]+"  |");
            }
            System.out.println();
        }
    }
}
