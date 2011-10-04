package ukol_1.min_max;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Domácí úkol číslo 1 (z cvičení 3), úloha č.3 - určení největšího, prostředního
 * a nejmenšího čísla z uživatelského vstupu
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class min_max {

    /**
     * scanner uživatelského vstupu
     */
    protected static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] cisla = new int[3];
        try {
            for (int i = 0; i < cisla.length; i++) {
                System.out.printf("Zadej %d.cislo: ",i+1);
                cisla[i] = sc.nextInt();

            }

        }catch(java.util.InputMismatchException e) {
            System.err.println("Neplatný vstup.");
        }

        Arrays.sort(cisla);
        System.out.println("-----------------");
        System.out.printf("nejvetsi: %d\nprostredni: %d\nnejmensi: %d\n", cisla[2], cisla[1], cisla[0]);


    }
}
