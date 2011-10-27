package ukol_4.bod_2;

/**
 *
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class dokonala_cisla {

    public static void main(String[] args) {
        /*
         * Owing to their form, 2p−1(2p−1), every even perfect number is
         * represented in binary as p ones followed by p − 1  zeros.
         * http://en.wikipedia.org/wiki/Perfect_number
         */
        String kandidat = "1";
        long current;

        /*
         * Mel bych to pocitat do milionu, ale pocitam to radsi do 100 000 000,
         * aby se tam tech cisel veslo aspon 5, jinak je to nuda.
         */
        while((current = Long.parseLong(kandidat = ("1"+kandidat+"0"), 2)) < 1e8) {
            if(jeDokonale(current)) {
                System.out.println(current);
            }
        }


    }

    /**
     * Ověří, zda je zadané číslo dokonalé
     * @param n
     * @return boolean
     */
    public static boolean jeDokonale(long n) {
        if (n % 2 == 1) { //licha cisla me nezajimaji
            return false;
        }
        long soucet_delitelu = 1;
        for (long i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                soucet_delitelu += i;
            }
        }
        return soucet_delitelu == n;
    }
}
