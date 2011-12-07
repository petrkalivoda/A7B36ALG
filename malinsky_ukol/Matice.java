package malinsky_ukol;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Petr Kalivoda <petr.kalivoda@gmail.com>
 */
public class Matice {
    
    protected int[][] matice;

    protected static Matice[] prohledavaneMatice;
    protected static Matice hledanaMatice;
    protected static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        hledanaMatice = nactiMatici("Zadejte velikost hledane matice (radek, sloupec):");
        System.out.println("-------------------------------------");
        System.out.println("Zadejte pocet prohledavanych matic:");
        do {
            try {
                prohledavaneMatice = new Matice[Integer.parseInt(sc.nextLine())];
            }catch(Exception e) {
                System.err.println("Chyba! Opakujte zadani.");
            }
        }while(!(prohledavaneMatice instanceof Matice[]));

        for (int i = 0; i < prohledavaneMatice.length; i++) { //nacteni prohledavanych matic
            prohledavaneMatice[i] = nactiMatici("Zadejte velikost "+(i+1)+". prohledavane matice (radek, sloupec):");
        }
        System.out.println("--------------Vysledky---------------");
        String vysledek = "";
        int pocetIdentickych = 0, pocetPodmatic = 0, curPodmatice = 0;
        
        for (int i = 0; i < prohledavaneMatice.length; i++) { //jedeme po jedne matici
            if(hledanaMatice.equals(prohledavaneMatice[i])) { //identicka matice
                vysledek += ((i+1)+". matice je identicka s hledanou matici\n");
                pocetIdentickych++;

            }else { //hledani podmatic
                curPodmatice = prohledavaneMatice[i].getPocetVyskytu(hledanaMatice);
                if(curPodmatice > 0) {
                    vysledek += (i+1)+". matice obsahuje hledanou matici "+curPodmatice+"x\n";
                    pocetPodmatic += curPodmatice;
                }
            }
        }

        System.out.printf("- hledani podmatic: %d, identickych matic: %d\n", pocetPodmatic, pocetIdentickych);
        System.out.println(vysledek);
    }

    protected static Matice nactiMatici(String rozmerovaHlaska) {
        Matice matice = null;
        StringTokenizer stRozmer, stObsah;
        String obsahovaHlaska;
        boolean correct = true;
        int m = 0, n = 0, count = 0, plnenyRadek = 0;

        System.out.println(rozmerovaHlaska);
        do { //overeni velikosti
            try {
                stRozmer = new StringTokenizer(sc.nextLine()); //rozmery matice
                if(stRozmer.countTokens() != 2) {
                    throw new IllegalArgumentException("Neplatny rozmer.");
                }
                m = Integer.parseInt(stRozmer.nextToken());
                n = Integer.parseInt(stRozmer.nextToken());
                matice = new Matice(m, n);
                correct = true;


            }catch(NumberFormatException e) { //neplatny integer
                System.err.println("Chyba! Opakujte zadani.");
                correct = false;
            }catch(IllegalArgumentException e) { //jedno nebo obe cisla < 1
                System.err.println(e.getMessage());
                correct = false;
            }
        } while(!correct);

        switch(m*n) { //zvoleni spravne hlasky
            case 1:
                obsahovaHlaska = "Zadejte 1 prvek matice:";
                break;

            case 2:
            case 4:
                obsahovaHlaska = "Zadejte "+(m*n)+" prvky matice:";
                break;

            default:
                obsahovaHlaska = "Zadejte "+(m*n)+" prvku matice:";
                break;
        }

        System.out.println(obsahovaHlaska);
        do { //naplneni matice prvky
            try {
                stObsah = new StringTokenizer(sc.nextLine());
                plnenyRadek = 0;
                count = 0;
                
                if(stObsah.countTokens() != (m*n)) {
                    correct = false; //spatnej pocet prvku
                    System.err.println("Chyba! Opakujte zadani!");
                    continue;
                }
                while(stObsah.hasMoreTokens()) {
                    matice.setPrvek(plnenyRadek, count++, Integer.parseInt(stObsah.nextToken()));
                    if(count == n) {
                        plnenyRadek++;
                        count = 0;
                    }
                }
                correct = true;
                
            }catch(NumberFormatException e) {
                //neplatny cislo
                System.err.println("Chyba! Opakujte zadani.");
                correct = false;
            }
        }while(!correct);

        return matice;
    }

    public Matice(int vyska, int sirka) throws IllegalArgumentException {
        if(vyska < 1 || sirka < 1) { //matice mensi nez 1x1, ne-e.
            throw new IllegalArgumentException("Chyba! Opakujte zadani!");
        }

        matice = new int[vyska][sirka];
    }

    public int getPocetVyskytu(Matice podmatice) {
        int vyskaM = podmatice.getVyska(), sirkaM = podmatice.getSirka(), pocetVyskytu = 0;
        if(vyskaM > matice.length || sirkaM > matice[0].length) { //matice je mensi nez "podmatice"
            return 0; //nemuze tim padem mit podmatici o vetsi velikosti
        }

        for (int x = 0; x <= (matice.length - vyskaM); x++) {
            for (int y = 0; y <= (matice[0].length - sirkaM); y++) {
                //ted se dostavame na XY-ty ofset - umoznuje vyskyt podmatice zejo.
                try {
                    for (int m = 0; m < vyskaM; m++) {
                        for (int n = 0; n < sirkaM; n++) {
                            if(matice[m+x][n+y] != podmatice.getPrvek(m, n)) {
                                throw new IllegalStateException("Rovnost je v pytli.");
                            }
                        }
                    }
                    pocetVyskytu++; //zvysime citac, joo! (uz me to fakt nebavi, btw.)
                }catch(IllegalStateException e) {
                    //nic, dalsi matrix na rade.
                }

            }

        }

        return pocetVyskytu;
    }

    public int getVyska() {
        return matice.length;
    }

    public int getSirka() {
        return matice[0].length;
    }

    public void setPrvek(int radek, int sloupec, int prvek) throws IllegalArgumentException {
        try {
            matice[radek][sloupec] = prvek;

        }catch(ArrayIndexOutOfBoundsException e) { //bylo zadano moc prvku
            throw new IllegalArgumentException("Chyba, opakujte zadani!");
        }
    }
    
    public int getPrvek(int radek, int sloupec) throws IllegalArgumentException {
        int prvek;
        try {
            prvek = matice[radek][sloupec];

        }catch(ArrayIndexOutOfBoundsException e) { //bylo zadano moc prvku
            throw new IllegalArgumentException("Prvek na ["+(radek+1)+","+(sloupec+1)+"] neexistuje.");
        }
        
        return prvek;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = true;
        if(!(obj instanceof Matice)) { //objekt neni matice
            return false;
        }

        Matice matice2 = (Matice)obj;

        if(matice2.getVyska() != matice.length || matice2.getSirka() != matice[0].length) {
            return false; //matice ma jiny rozmer
        }

        try {
            for (int m = 0; m < matice.length; m++) {
                for (int n = 0; n < matice.length; n++) {
                    if(matice[m][n] != matice2.getPrvek(m, n)) {
                        throw new Exception("Rovnost je v pytli.");
                    }
                }
            }
        }catch(Exception e) {
            equal = false;
        }
        return equal;
    }

    @Override
    public int hashCode() {
        return matice.hashCode();
    }

    @Override
    public String toString() {
        String[][] retmatrix = new String[matice.length][matice[0].length];
        int maxlen, remainder;
        String retstring = "";

        for (int n = 0; n < retmatrix.length; n++) {
            maxlen = 0;
            for (int m = 0; m < retmatrix.length; m++) { //zjisteni nejvetsiho, zapsani prvku
                retmatrix[m][n] = ""+matice[m][n];
                if(maxlen < retmatrix[m][n].length()) {
                    maxlen = retmatrix[m][n].length();
                }
            }

            for (int m = 0; m < retmatrix[0].length; m++) { //dorovnani mezer
                remainder = maxlen - retmatrix[m][n].length();
                for (int c = 0; c < remainder; c++) {
                    retmatrix[m][n] = " "+retmatrix[m][n];
                }
            }
        }

        for (int m = 0; m < retmatrix.length; m++) { //vytvoreni vysledneho stringu
            for (int n = 0; n < retmatrix.length; n++) {
                retstring += retmatrix[m][n] + " ";
            }
            retstring += "\n"; //odradkovani
        }
        return retstring;
    }

}
