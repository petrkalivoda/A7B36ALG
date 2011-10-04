package ukol_2.trojuhelnik;
import java.util.Scanner;

/**
 * Domácí úkol číslo 2 (z cvičení 4) - vlastnosti trojúhelníku
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class trojuhelnik {

    //strany
    protected double a = 0;
    protected double b = 0;
    protected double c = 0;
    
    //vnitrni uhly
    protected double alpha = 0;
    protected double beta = 0;
    protected double gamma = 0;

    protected static Scanner sc = new Scanner(System.in);

    /**
     *
     * @param a strana a
     * @param b strana b
     * @param c strana c
     */
    public trojuhelnik(double a, double b, double c) {
        if((a+b) > c && (a+c) > b && (b+c) > a && a > 0 && b > 0 && c > 0) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.alpha = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2))/(2*b*c)) * (180/Math.PI);
            this.beta = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2))/(2*a*c)) * (180/Math.PI);
            this.gamma = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2))/(2*b*b)) * (180/Math.PI);
            
        }else {
            throw new IllegalArgumentException(String.format("Trojúhelník s rozměry %.2fx%.2fx%.2f nelze sestrojit.", a, b, c));
        }
    }

    /**
     * Ověřuje, zda je trojúhelník rovnostranný
     * @return
     */
    public boolean jeRovnostranny() {
        return a == b && b == c;
    }

    /**
     * Ověřuje, zda je trojúhelník rovnoramenný
     * @return
     */
    public boolean jeRovnoramenny() {
        return a == b || a == c || b == c;
    }

    /**
     * Ověřuje, zda je trojúhelník pravoúhlý
     * @return
     */
    public boolean jePravouhly() {
        return alpha == 90 || beta == 90 || gamma == 90;
    }

    public static void main(String[] args) {
        double[] rozmery = new double[3];
        try {
            System.out.print("Zadej stranu a: ");
            rozmery[0] = sc.nextDouble();
            System.out.print("Zadej stranu b: ");
            rozmery[1] = sc.nextDouble();
            System.out.print("Zadej stranu c: ");
            rozmery[2] = sc.nextDouble();

            trojuhelnik tr = new trojuhelnik(rozmery[0], rozmery[1], rozmery[2]);
            System.out.print("Trojúhelník lze sestrojit");
            if(tr.jeRovnostranny()) {
                System.out.print(", je rovnostranný");
            }else if (tr.jeRovnoramenny()) {
                System.out.print(", je rovnoramenný");
            }

            if(tr.jePravouhly()) {
                System.out.print(", je pravoúhlý");
            }

            System.out.println(".");


        }catch(java.util.InputMismatchException e) {
            System.err.println("Neplatný vstup.");
        }catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

}
