package ukol_1.casovy_interval;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Domácí úkol číslo 1 (z cvičení 3), úloha č.1 - časový interval
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class casovy_interval {

    protected static final int NEJAKY_ROK = 1990;
    protected static final int NEJAKY_MESIC = 9;
    protected static final int NEJAKY_DEN = 16;

    protected static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] casy = new int[2][3];
        try {
            System.out.print("Zadej hodinu 1: ");
            casy[0][0] = sc.nextInt();
            System.out.print("Zadej minutu 1: ");
            casy[0][1] = sc.nextInt();
            System.out.print("Zadej sekundu 1: ");
            casy[0][2] = sc.nextInt();
            System.out.print("Zadej hodinu 2: ");
            casy[1][0] = sc.nextInt();
            System.out.print("Zadej minutu 2: ");
            casy[1][1] = sc.nextInt();
            System.out.print("Zadej sekundu 2: ");
            casy[1][2] = sc.nextInt();

        }catch(java.util.InputMismatchException e) {
            System.err.println("Neplatný vstup.");
        }
        
        Date d1 = new Date(NEJAKY_ROK, NEJAKY_MESIC, NEJAKY_DEN, casy[0][0], casy[0][1], casy[0][2]);
        Date d2 = new Date(NEJAKY_ROK, NEJAKY_MESIC, NEJAKY_DEN+(casy[1][0] > casy[0][0] ? 0 : 1), casy[1][0], casy[1][1], casy[1][2]);
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
        long diff = (d2.getTime() - d1.getTime()) / 1000;

        System.out.printf("Mezi %s a %s ubehlo %d minut, tj.", sf.format(d1), sf.format(d2), (diff/60));
        System.out.printf(" %d hodin", diff/60/60);
        System.out.printf(", %d minut", (diff/60)-(diff/60/60 /*hodiny*/)*60);
        System.out.printf(", %d sekund.", diff - (diff/60 /* minuty */)*60);
        System.out.printf("\n");
    }
}