/*
    Parte 4: Funzione Aggiuntiva

    Obiettivo: Aggiungere una funzione che permetta agli utenti di cambiare la password.
    Dettagli:
    Chiedere all'utente la vecchia password, poi la nuova password.
    Verificare che la vecchia password sia corretta prima di permettere il cambio con la nuova.
    Aggiornare la password nell'archivio dati.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    ArrayList<Account> accounts = new ArrayList<>();

    public void cambiaPassword(Account account) {
        Scanner scanner = new Scanner(System.in);
        String nuovaPassword;

        // Chiedi la vecchia password
        System.out.println("Inserisci la vecchia password:");
        String vecchia_password = scanner.nextLine();

        // Verifica che la vecchia password sia corretta
        if (account.getPassword().equals(vecchia_password)) {
            // Chiedi la nuova password
            
            do {
                System.out.println("Inserisci la nuova password (almeno 8 caratteri):");
                nuovaPassword = scanner.nextLine();
    
                if (nuovaPassword.length() < 8) {
                    System.out.println("La nuova password deve avere almeno 8 caratteri.");
                }
    
            } while (nuovaPassword.length() < 8);

            // Aggiorna la password nell'archivio dati
            account.setPassword(nuovaPassword);

            System.out.println("Password cambiata con successo.");
        } else {
            System.out.println("Vecchia password errata. Impossibile cambiare la password.");
        }
    }


    //add singletony
}