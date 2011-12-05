package semestralni_test;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class posloupnost {
        
    protected static Scanner sc = new Scanner(System.in);
    protected static int soucet = 0;
    protected static int cislo = 0;
    protected static int pocet =  0;

    public static void main(String[] args) {
        System.out.print("Zadejte cislo: ");
        try {
            while((cislo = sc.nextInt()) != 0) {
                soucet += cislo;
                pocet++;
                System.out.print("Zadejte dalsi cislo: ");
            }

            if(pocet == 0) {
                throw new Exception("Je treba zadat aspon jedno cislo.");
            }
         
            System.out.printf("Prumer zadanych cisel: %.2f\n", (float)soucet/pocet);

        }catch(InputMismatchException e) {
            System.err.println("Musite zadat platne cele cislo.");
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
