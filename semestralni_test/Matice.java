package semestralni_test;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class Matice {

    protected static Scanner sc = new Scanner(System.in);

    protected int[][] matice;

    /**
     *
     * @param m pocet radku
     * @param n pocet sloupcu
     * @throws IllegalArgumentException
     */
    public Matice(int m, int n) throws IllegalArgumentException {
        if(m < 1 || n < 1) {
            throw new IllegalArgumentException("Matice musi byt aspon 1x1.");
        }

        matice = new int[m][n]; //m = radky, n = sloupce
    }

    public void naplnMN(int m, int n, int hodnota) throws IllegalArgumentException {
        try {
            matice[m][n] = hodnota;

        }catch(ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Ofset "+m+":"+n+" neexistuje.");
        }
    }
    
    /**
     * testovaci vypis matice
     */
    public void vypisMatici() {
        for (int i = 0; i < matice.length; i++) {
            for (int j = 0; j < matice[i].length; j++) {
                System.out.printf("%d ", matice[i][j]);                
            }
            System.out.printf("\n");
        }
    }

    public void vypisMinimalniAbsolutniHodnotu() {
        int hodnota = Integer.MAX_VALUE;
        int temp = 0;

        for (int m = 0; m < matice.length; m++) {
            for (int n = 0; n < matice.length; n++) {
                 temp = Math.abs(matice[m][n]);
                 if(temp < hodnota) {
                     hodnota = temp; //zapise nejmensi absolutni hodnotu pokud je mensi nez stavajici
                 }
            }
        }

        System.out.printf("Minimalni absolutni hodnota v matici je %d.\n", hodnota);
    }

    /**
     * Vypise minimalni soucet sloupce matice a jeho cislo.
     */
    public void vypisMinimalniSoucetSloupce() {
        int soucet = Integer.MAX_VALUE;
        int soucet_temp = 0;
        int cislo_sloupce = 0;

        for (int n = 0; n < matice.length; n++) {
            soucet_temp = 0;
            for (int m = 0; m < matice.length; m++) {
                soucet_temp += matice[m][n]; //pricte prvek matice

            }
            if(soucet > soucet_temp) {
                soucet = soucet_temp;
                cislo_sloupce = n+1;
            }

        }

        System.out.printf("Minimalni soucet sloupce matice je ve %d. sloupci: %d.\n", cislo_sloupce, soucet);
    }

    public static void main(String[] args) {
        int m = 0, n = 0;
        try {

            //inicializace matice
            System.out.print("Zadejte pocet radku matice: ");
            m = sc.nextInt();
            System.out.print("Zadejte pocet sloupcu matice: ");
            n = sc.nextInt();
            Matice matice = new Matice(m, n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("Zadejte %d. prvek %d. radku: ", j+1, i+1);
                    matice.naplnMN(i, j, sc.nextInt());
                }

            }

            System.out.println("------------------------------------------");
            System.out.println("Zadana matice:");
            matice.vypisMatici();
            System.out.println("------------------------------------------");
            matice.vypisMinimalniSoucetSloupce();
            matice.vypisMinimalniAbsolutniHodnotu();

        }catch(InputMismatchException e) {
            System.err.println("Veskera cisla musi byt platna cela cisla.");

        }catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}
