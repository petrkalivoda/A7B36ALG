package ukol_4.bod_1;

/**
 * "Dále napište funkci, která pro zadané hranice uzavřeného intervalu zjistí, kolik obsahuje druhých mocnin."
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class interval {

    protected static java.util.Scanner sc = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        try {
            int start, end;
            System.out.printf("Zadejte počáteční číslo intervalu: ");
            start = sc.nextInt();
            System.out.printf("Zadejte koncové číslo intervalu: ");
            end = sc.nextInt();
            System.out.printf("Interval <%d;%d> obsahuje %d druhých mocnin.\n" , start, end, Mocniny.kolikDruhychMocninObsahujeInterval(start, end));

        }catch(java.util.InputMismatchException e) {
            System.err.println("Neplatný vstup.");
        }catch(java.lang.IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

}
