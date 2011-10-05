package ukol_3.bod_2;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * "Modifikujte předchozí příklad (ukol_3.bod_1) tak, aby trojúhelník vypadal jako
 * rovnoramenný a jeho velikost byla parametrizovatelná. Např. pro zadané číslo 11
 * bude první řádek složen z 5 mezer a jedné hvězdičky, druhý ze 4 mezer a 3
 * hvězdiček, poslední řádek bude z 11 hvězdiček."
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class bod_2 {
    
    protected static Scanner sc = new Scanner(System.in);
    protected static int velikost = 0;

    public static void main(String[] args) {
        System.out.print("Zadejte velikost posledního řádku: ");
        try {
            velikost = sc.nextInt();
            if(velikost < 3) {
                throw new IllegalArgumentException("Nelze vykreslit trojúhelník s velikostí posledního řádku menší než tři.");
            }
            
            if(velikost % 2 == 0) {
                throw new IllegalArgumentException("Pro korektní vykreslení rovnoramenného trojúhelníku je třeba zadat liché číslo.");
            }
            
            for (int i = 1; i <= velikost; i++) {
                if(i % 2 == 0) {
                    //pro suda cisla radku nic nevykreslujeme
                    continue;
                }
                
                for (int j = 0; j < velikost; j++) {
                    if(j < ((velikost-i)/2)) {
                        System.out.print(" ");

                    }else if(j >= (velikost-i)/2 && i >= (velikost-j)) {
                        System.out.print("*");
                    }                    
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
