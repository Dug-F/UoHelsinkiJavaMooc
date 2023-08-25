
import java.util.ArrayList;


public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here
        
//        MagicSquareFactory msFactory = new MagicSquareFactory();
//        System.out.println(msFactory.createMagicSquare(5));

        int[][] arr = {{1, 1}, {5, 7}};
        MagicSquare ms = new MagicSquare(2);
        ms.placeValue(0,0, 1);
        ms.placeValue(1,0, 1);
        ms.placeValue(0,1, 5);
        ms.placeValue(1,1, 7);
        ArrayList<Integer> sumsOfDiagonals = ms.sumsOfDiagonals();
        System.out.println(sumsOfDiagonals);
    }
}
