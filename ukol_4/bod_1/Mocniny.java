
package ukol_4.bod_1;

/**
 *
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class Mocniny {

    public static void main(String[] args) {
        System.out.println(kolikDruhychMocninObsahujeInterval(4, 9));
    }

    /**
     * Ověří, zda je číslo celočíselnou druhou mocninou nějakého jiného čísla
     * @param n číslo
     * @return boolean
     */
    public static boolean jeDruhaMocnina(int n) throws IllegalArgumentException {
        if(n < 0) {
            throw new IllegalArgumentException("Počáteční číslo nesmí být záporné.");
        }
        return Math.sqrt(n) == Math.round(Math.sqrt(n));
    }


    /**
     * Vrací počet celočíselných druhých mocnin v daném intervalu
     * @param start
     * @param end
     * @return integer
     * @throws IllegalArgumentException
     */
    public static int kolikDruhychMocninObsahujeInterval(int start, int end)
            throws IllegalArgumentException {

        if(start >= end){
            throw new IllegalArgumentException("Počáteční číslo musí být větší než koncové.");
        }

        int pocet = 0;
        while(start <= end) {
            if(jeDruhaMocnina(start++)) {
                pocet++;
            }
        }

        return pocet;
    }
}
