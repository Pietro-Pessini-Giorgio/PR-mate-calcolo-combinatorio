import java.util.ArrayList;

public class CombinatorioCompleto {

    // Fattoriale
    public static long fattoriale(int n) {
        long risultato = 1;
        for (int i = 2; i <= n; i++) {
            risultato *= i;
        }
        return risultato;
    }

    // Permutazioni semplici: P(n) = n!
    public static long permutazioni(int n) {
        return fattoriale(n);
    }

    // Disposizioni semplici: D(n, k) = n! / (n - k)!
    public static long disposizioni(int n, int k) {
        return fattoriale(n) / fattoriale(n - k);
    }

    // Disposizioni con ripetizione: D'(n, k) = n^k
    public static long disposizioniConRipetizione(int n, int k) {
        return (long) Math.pow(n, k);
    }

    // Combinazioni semplici: C(n, k) = n! / (k! * (n - k)!)
    public static long combinazioni(int n, int k) {
        return fattoriale(n) / (fattoriale(k) * fattoriale(n - k));
    }

    // Combinazioni con ripetizione: C'(n, k) = C(n + k - 1, k)
    public static long combinazioniConRipetizione(int n, int k) {
        return combinazioni(n + k - 1, k);
    }

    // Permutazioni con ripetizione: P'(n) = n! / (p1! * p2! * ... * pk!)
     public static long permutazioniConRipetizione(int n,ArrayList<Integer> ricorrenze) {
        long denominatore = 1;

        for(int ricor:ricorrenze) {
            denominatore*=fattoriale(ricor);
        }
        return fattoriale(n) / denominatore;
    }
}
