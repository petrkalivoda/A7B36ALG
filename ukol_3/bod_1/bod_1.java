package ukol_3.bod_1;

/**
 * "Pomocí cyklu napište program, který "vykreslí" do výstupu trojúhelník.
 * Na prvním řádku bude 1 hvězdička, na druhém 2, atd.
 * Na posledním, desátém řádku jich bude 10."
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class bod_1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int j = 0;
            while(++j<=i) System.out.print((j==i ? "*\n" : "*"));
        }
    }
}
