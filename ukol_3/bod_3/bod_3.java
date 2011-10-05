package ukol_3.bod_3;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * "Obdobně vykreslete obdélník se zadanou šířkou a výškou."
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class bod_3 {
    
    protected static Scanner sc = new Scanner(System.in);
    protected static int vyska = 0;
    protected static int sirka = 0;

    public static void main(String[] args) {
        try {
            System.out.print("Zadej šířku: ");
            sirka = sc.nextInt();
            System.out.print("Zadej výšku: ");
            vyska = sc.nextInt();

            if(sirka < 1 || vyska < 1) {
                throw new IllegalArgumentException("Výška i šířka musí být kladná čísla.");
            }

            for (int i = 0; i < vyska; i++) {
                for (int j = 0; j < sirka; j++) {
                    System.out.print("*");
                }

                System.out.print("\n");

            }

        }catch(InputMismatchException e) {
            System.err.println("Neplatný vstup.");

        }catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());

        }
    }
}
