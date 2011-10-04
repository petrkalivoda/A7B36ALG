package ukol_1.soustava_rovnic;
import java.util.Scanner;

/**
 * Domácí úkol číslo 1 (z cvičení 3), úloha č.2 - soustava rovnic 3x3
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class soustava_rovnic {

    /**
     * scanner uživatelského vstupu
     */
    protected static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        double[][] soustava = nactiSoustavu();
        
        /**
         * Nevidím pointu v psaní vlastního algoritmu pro Gaussovu eliminaci,
         * proto jsem použil hotové řešení.
         */
        double[] vysledek = GaussianElimination.lsolve(
            new double[][] {
                {soustava[0][0], soustava[0][1], soustava[0][2]},
                {soustava[1][0], soustava[1][1], soustava[1][2]},
                {soustava[2][0], soustava[2][1], soustava[2][2]}
            },
            new double[] {soustava[0][3], soustava[1][3], soustava[2][3]}
        );

        System.out.printf("x = %.2f\ny = %.2f\nz = %.3f\n", vysledek[0], vysledek[1], vysledek[2]);

    }

    /**
     * Načte soustavu rovnic z příkazové řádky
     */
    protected static double[][] nactiSoustavu(){
        double[][] cisla = new double[3][4];
        try {
            for(int i=0;i<=2;i++) {
                for(int j=0;j<=2;j++) {
                    System.out.printf("Zadej a%d%d: ", i+1, j+1);
                    cisla[i][j] = sc.nextDouble();
                }

                System.out.printf("Zadej b%d: ",i+1);
                cisla[i][3] = sc.nextDouble();
            }

        }catch(java.util.InputMismatchException e) {
            System.err.println("Neplatný vstup.");
        }

        return cisla;
    }
}
