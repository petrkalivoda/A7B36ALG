package ukol_3.bod_5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * "Pokročilí: Vykreslete kružnici o zadaném poloměru."
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class bod_5 {

    protected static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Zadej poloměr: ");
            int radius = sc.nextInt();
            if(radius < 2) {
                System.out.println("Nemá smysl se pokoušet vypsat do konzole kružnici o poloměru menším než 2.");
            }

            boolean[][] kruh = new boolean[2*radius][2*radius];
            for (int y = -radius; y < radius; y++) {
                int half_row_width = (int)Math.round(Math.sqrt(radius * radius - y * y));
                for (int x = -half_row_width; x < half_row_width; x++) {
                    kruh[radius+y][radius+x] = true;
                }
            }

            for (int i = 0; i < kruh.length; i++) {
                for (int j = 0; j < kruh[i].length; j++) {
                    System.out.print(kruh[i][j] ? "*" : " ");
                }
                System.out.print("\n");
            }
            

        }catch(InputMismatchException e) {
            System.err.println("Neplatný vstup.");
        }catch(IllegalArgumentException e)  {
            System.err.println(e.getMessage());
        }
    }
}
