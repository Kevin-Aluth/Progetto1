import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta = 0;
        String risposta = "";
        
        do{
            do{
                System.out.println("---MENU---");
                System.out.println("1. Login");
                System.out.println("2. Esci");
                System.out.print("Inserisci la tua scelta: ");

                scelta = scanner.nextInt();
                if(scelta < 1 || scelta > 2) System.out.println("Scelta non valida");
            } while(scelta < 1 || scelta > 2);

            switch (scelta) {
                case 1:
                    System.out.println("LOGIN");
                    // System.out.println("Inserisci username: ");
                    // String username = scanner.next();
                    // System.out.println("Inserisci password: ");
                    // String password = scanner.next();
                    break;
                case 2:
                    System.out.println("Arrivederci!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }

            System.out.print("Vuoi effettuare un altro login? (si / no)  ");
            risposta = scanner.next();
            if(risposta.equalsIgnoreCase("no")) {
                System.out.println("Arrivederci!");
                System.exit(0);
            }

        } while(risposta.equalsIgnoreCase("si"));
    }
}
