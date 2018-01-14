

import java.util.HashSet;
import java.util.Scanner;

public class Turn {
   // HashSet<Pos> plays = new HashSet<>();
    boolean[][] plays;
    int length;
    int width;


    public  Turn(int length, int width){
       // size = length*width;
        this.length=length-1;
        this.width = width-1;
        plays = new boolean[length][width];
    }

    /**
     * Plays a turn
     * @param p Position Class with row and col position
     * @param b Game Board
     */
    public void play(Pos p, Board b){
        System.out.println("Your Current Position: ("+p.x+","+p.y+") in green");
        try {
            plays[p.x][p.y] = true;
           // b.remaining.remove(p);
        }
        catch (Exception e){

           // throw new ArrayIndexOutOfBoundsException();

            throw new RuntimeException("You selected wrong position. Please select between (0,"+length+") and (0,"+width+")");
           // throw new Excepti`on("You selected wrong position. Please select between (0,"+length+") and (0,"+width+")");
        }


        if(b.board[p.x][p.y]=="D"){
            showBoard(p,b);
            System.out.println("You opened Bomb Tile!!!!" +
                    "\n GAME OVER!");

            Scanner sc = new Scanner(System.in);
            System.out.println("Do you want to see board? yes, no");
            if(sc.next().toLowerCase().equals("yes")){
                b.printBoard();
            }
            System.exit(1);
        }

        checkWin(p,b);
        showBoard(p,b);
       // return 1;
    }
    private void showBoard(Pos p, Board b){
        String[][] boards = b.board;
        //System.out.println(boards.length+" ,"+boards[0].length);
        for(int r=0;r < boards.length;r++){
            System.out.print("|");
            for(int c=0;c< boards[0].length;c++){

                    if(plays[r][c]) {
                        if(p.x==r&&p.y==c){
                            System.out.print("\033[32;1;2m  " + boards[r][c] + "\033[0m  |");
                        }
                        else {
                            System.out.print("\033[34m  " + boards[r][c] + "\033[0m  |");
                        }
                    }
                    else {
                        System.out.print("  .  |");
                    }

            }
            System.out.println();
        }

        System.out.print("\n");
    }

    public void checkWin(Pos p,Board b){
        String[][] bb = b.board;
        for(int r=0;r < bb.length;r++){
           // System.out.print("|");
            for(int c=0;c< bb[0].length;c++){
               if(!plays[r][c]&& bb[r][c]!="D"){
                   return;
               }
            }

        }

            System.out.println("You won the game!! Congrats!!");
            showBoard(p,b);
            b.printBoard();
            System.exit(1);

    }
}

