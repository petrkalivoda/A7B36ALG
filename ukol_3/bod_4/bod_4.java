package ukol_3.bod_4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * "Pokročilí: Vykreslete obdélník a v něm úhlopříčky."
 * @link http://en.wikipedia.org/wiki/Digital_differential_analyzer_(graphics_algorithm)
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class bod_4 {

    protected static Scanner sc = new Scanner(System.in);
    protected static int vyska = 0;
    protected static int sirka = 0;

    public static void main(String[] args) {
        try {
            System.out.print("Zadej šířku: ");
            sirka = sc.nextInt();
            System.out.print("Zadej výšku: ");
            vyska = sc.nextInt();

            if (sirka < 3 || vyska < 3) {
                throw new IllegalArgumentException("Nemá smysl se pokoušet vypisovat úhlopříčky v konzoli v obdélníku menším než 3x3.");
            }

            boolean[][] obdelnik = new boolean[vyska][sirka];
            obdelnik = drawLine(obdelnik, 0, vyska - 1, sirka - 1, 0);
            obdelnik = drawLine(obdelnik, sirka - 1, vyska-1, 0, 0);

            for (int i = 0; i < obdelnik.length; i++) {
                for (int j = 0; j < obdelnik[i].length; j++) {
                    System.out.print(obdelnik[i][j] ? "+" : "*");
                }
                System.out.print("\n");
            }



        } catch (InputMismatchException e) {
            System.err.println("Neplatný vstup.");

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());

        }
    }

    protected static boolean[][] drawLine(boolean[][] obdelnik, int xstart, int ystart, int xend, int yend) {
        double smernice = (double) (yend - ystart) / (double) (xend - xstart);

        if (xstart > xend) { System.out.println("prohazujeme");
            //pokud jde uhlopricka zprava do leva, prohazujeme body
            //starej trik z ucebnic :-)
            xstart ^= xend ^= xstart ^= xend;
            ystart ^= yend ^= ystart ^= yend;
        }

        double point_y = ystart;
        for (int i = xstart; i <= xend; i++) {
            obdelnik[(int)Math.round(point_y)][i] = true;
            //dopocitavame y
            point_y = ((double) (point_y + smernice));
        }
        return obdelnik;
    }
}