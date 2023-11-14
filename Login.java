/*
    Parte 4: Funzione Aggiuntiva

    Obiettivo: Aggiungere una funzione che permetta agli utenti di cambiare la password.
    Dettagli:
    Chiedere all'utente la vecchia password, poi la nuova password.
    Verificare che la vecchia password sia corretta prima di permettere il cambio con la nuova.
    Aggiornare la password nell'archivio dati.
*/

import java.util.HashMap; 
import java.util.Scanner; 

public class Login {
    HashMap<Integer, Account> accounts = new HashMap<>();
    static Login instance = null; 
    int counter = 1; 

    private Login(){}
    public static Login LoginClass(){
        if(instance == null){
            instance = new Login(); 
        }
        return instance;
    }

    public boolean checkUsername(String username){
        for(int i : accounts.keySet()){
            if(accounts.get(i).getUsername().equals(username)){
                return true; 
            }
        }
        return false;
    }

    public Account checkLogin(String username, String password){
        Account activeAccount = null;  
        
        for(int i : accounts.keySet()){
            if(accounts.get(i).getUsername().equals(username)){
                System.out.println("Account found");
                activeAccount = accounts.get(i); 
                break; 
            }
        }
        if(activeAccount == null) {
            System.out.println("account not found");
            return null; 
        }
        if(!activeAccount.getPassword().equals(password)){
            System.out.println("password incorrect");
            return null; 
        }
        return activeAccount; 
    }

    public HashMap<Integer, Account> getAccounts(){
        return accounts; 
    }

    public void addToAccount(Account account){
        accounts.put(counter, account); 
        accounts.get(counter).setId(counter);
        counter++; 
    }

    public void removeAccount(int id){
        accounts.remove(id); 
    }

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

}