import java.util.Scanner;

/**
 * Minesweeper
 * Dhananjay Patil
 * Email: dhananjay.dj.patil@gmail.com
 */
public class Minesweeper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Minesweeper Game!!");
        System.out.println("Rules and how to play:\n" +
                "1. You enter the size of minesweeper board i.e. length and width\n" +
                "2. Then the board will be automatically initiated with bombs placed randomly\n" +
                "3. After that you will be asked to enter the position of Tile you want to reveal. Please provide co-ordinates row number and column number\n" +
                "4. Each position may reveal 3 values \n\t a) S: Safe Tile \n\t b) D: Bomb Tile \n\t c) Number: No. of Bombs adjacent to this tile" +
                "\n5. After each turn you will be shown the board with all your moves" +
                "\n\nNOW LET'S START!! Best of Luck!!\n\n");
        System.out.println("Please enter board length");
        int length = sc.nextInt();
        System.out.println("Please enter board width");
        int width = sc.nextInt();
       // System.out.println("Please enter board length");
        int complexity = (40*length*width)/100;
        System.out.println("Default Complexity 40%" +
                "\n i.e. No. of Bombs:"+complexity);

        Board b = new Board(length,width,complexity);
        System.out.println("\n");

        Turn t = new Turn(length,width);
       // t.play(new Pos(3,4),b);
       // t.play(new Pos(2,3),b);
       // t.play(new Pos(-1,1),b);

        String play = "yes";
        while(play.toLowerCase().equals("yes")){
            System.out.println("Please enter position row");
            int row = sc.nextInt();
            System.out.println("Please enter position col");
            int col = sc.nextInt();
            t.play(new Pos(row,col),b);

            System.out.println("Do you want to continue? yes, no");
            play = sc.next();
        }
       // System.out.println("\033[32;1;2mTest Color!\033[0m");

        sc.close();
    }
}
