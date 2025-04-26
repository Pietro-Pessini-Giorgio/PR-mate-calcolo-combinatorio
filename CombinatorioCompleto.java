import java.util.Scanner;

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

    // Main con input da tastiera
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci n: ");
        int n = scanner.nextInt();

        System.out.print("Inserisci k: ");
        int k = scanner.nextInt();

        System.out.println("\nScegli una formula:");
        System.out.println("1 - Permutazioni semplici (P(n))");
        System.out.println("2 - Disposizioni semplici (D(n,k))");
        System.out.println("3 - Disposizioni con ripetizione (D'(n,k))");
        System.out.println("4 - Combinazioni semplici (C(n,k))");
        System.out.println("5 - Combinazioni con ripetizione (C'(n,k))");

        System.out.print("Scelta: ");
        int scelta = scanner.nextInt();

        long risultato = 0;

        switch (scelta) {
            case 1:
                risultato = permutazioni(n);
                break;
            case 2:
                risultato = disposizioni(n, k);
                break;
            case 3:
                risultato = disposizioniConRipetizione(n, k);
                break;
            case 4:
                risultato = combinazioni(n, k);
                break;
            case 5:
                risultato = combinazioniConRipetizione(n, k);
                break;
            default:
                System.out.println("Scelta non valida.");
                scanner.close();
                return;
        }

        System.out.println("Risultato: " + risultato);
        scanner.close();
    }
}
