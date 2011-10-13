package factorial;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


/**
 * Výpočet factorialu hodně velkejch čísel.
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class factorial {

    protected static BigInteger vysledek = new BigInteger("1");
    protected static BigInteger cislo;
    protected static BigInteger progress;
    protected static Scanner sc = new Scanner(System.in);
    protected static BufferedWriter console = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) {
        System.out.printf("Zadej cislo: ");
        try {
            cislo = new BigInteger(sc.next());
            progress = cislo.divide(BigInteger.TEN);

            while(cislo.compareTo(BigInteger.ONE) == 1) {
                vysledek = vysledek.multiply(cislo);
                
                //kazdych cislo/10 iteraci napiseme tecku, takovej malej progress bar.
                if(cislo.mod(progress).equals(BigInteger.ZERO)) {
                    System.out.print(".");
                }

                cislo = cislo.subtract(BigInteger.ONE);

            }

            System.out.print("\nVysledek: ");
            console.write(vysledek.toString());
            console.write("\n");
            console.flush();

        }catch(Exception e) {
            //normalne NIKDY nechytat obecnou vyjimku, tohle je jen pro demonstraci!!!
            System.err.println(e.getMessage());
        }

    }

}
