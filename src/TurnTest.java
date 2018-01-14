import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TurnTest {
    @Test
    void play() {
        Board b = new Board(9,9,40);
        // System.out.println("\n\n");
        //  b.printBoard();
        Turn t = new Turn(5,6);
        //assertNull(t.play(new Pos(3,4),b));
    }



    @Test()
     void checkPlay() throws Exception{
        Board b = new Board(9,9,40);
        // System.out.println("\n\n");
        //  b.printBoard();
        Turn t = new Turn(5,6);

      //  expectedException.expect(new RuntimeException("You selected wrong position. Please select between (0,4) and (0,5)").getClass());
       // t.play(new Pos(-3,4),b);

        RuntimeException e = assertThrows(RuntimeException.class, () -> {
            t.play(new Pos(-3,4),b);
        });
        assertEquals("You selected wrong position. Please select between (0,4) and (0,5)", e.getMessage());
     //   (RuntimeException.class);
    }



    @Test
    void checkPlay2(){
        Board b = new Board(9,9,40);
        // System.out.println("\n\n");
        //  b.printBoard();
        Turn t = new Turn(5,6);
  //      Assert.assertEquals(t.play(new Pos(-3,-4),b),1);
    }


}