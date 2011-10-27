package ukol_4.bod_1;


/**
 * "Napište funkci, která zjistí zda zadané číslo je celočíselnou druhou mocninou nějakého čísla."
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class overeni_mocniny {

    protected static java.util.Scanner sc = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.printf("Zadejte číslo: ");
            int n = sc.nextInt();

            if(Mocniny.jeDruhaMocnina(n)) {
                System.out.printf("Číslo %d je druhou mocninou čísla +-%.0f.\n", n, Math.sqrt(n));
            }else {
                System.out.printf("Číslo %d není druhou mocninou žádného čísla.\n", n);
            }

        }catch(java.util.InputMismatchException e) {
            System.err.println("Neplatný vstup.");
        }catch(java.lang.IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}