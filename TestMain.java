import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta = 0;
        String risposta = "";

        Login login = Login.LoginClass();
        
        do{
            do{
                System.out.println("---MENU---");
                System.out.println("1. Login");
                System.out.println("2. Registrati");
                System.out.println("3. Esci");
                System.out.print("Inserisci la tua scelta: ");

                scelta = scanner.nextInt();
                if(scelta < 1 || scelta > 3) System.out.println("Scelta non valida");
            } while(scelta < 1 || scelta > 3);

            switch (scelta) {
                case 1:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Inserisci username: ");
                    String username = scanner1.nextLine();
                    System.out.println("Inserisci password: ");
                    String password = scanner1.nextLine();

                    Account account = new Account(username, password);
                    account = login.checkLogin(username, password);
                    if(account == null){
                        System.out.println("Username o password errati");
                        break;
                    }

                    while (account != null){
                        int scelta2 = 0;
                        do{
                            System.out.println("Menu:");
                            System.out.println("1. Aggiungi informazioni");
                            System.out.println("2. Visualizza le informazioni");
                            System.out.println("3. Modifica le informazioni");
                            System.out.println("4. Elimina account");
                            System.out.println("5. Esci");

                            scelta2 = scanner.nextInt();
                            
                            if (scelta2 < 1 || scelta2 > 5) System.out.println("Scelta non valida");
                        } while(scelta2 < 1 || scelta2 > 5);
                        
                        switch(scelta2){
                            case 1:
                                System.out.println("Inserisci il tuo nome: ");
                                String nome = scanner.nextLine();
                                System.out.println("Inserisci il tuo cognome: ");
                                String cognome = scanner.nextLine();
                                System.out.println("Inserisci la tua email: ");
                                String email = scanner.nextLine();
                                System.out.println("Inserisci il tuo indirizzo: ");
                                String indirizzo = scanner.nextLine();
                                account.setNome(nome);
                                account.setCognome(cognome);
                                account.setEmail(email);
                                account.setIndirizzo(indirizzo);
                                break;
                            case 2:
                                System.out.println("Username: " + account.getUsername());
                                System.out.println("Nome: " + account.getNome());
                                System.out.println("Cognome: " + account.getCognome());
                                System.out.println("Email: " + account.getEmail());
                                System.out.println("Indirizzo: " + account.getIndirizzo());
                                break;
                            case 3:
                                login.cambiaPassword(account);
                                break;
                            case 4:
                                login.getAccounts().remove(account);
                                account = null;
                                break;
                            case 5:
                                System.out.println("Arrivederci!");
                                account = null;
                                break;
                            default:
                                System.out.println("Scelta non valida");
                                break;
                        }
                    }
                    
                    break;
                case 2:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Inserisci username: ");
                    String username2 = scanner2.nextLine();

                    if(login.checkUsername(username2)){
                        System.out.println("Username già esistente");
                        break;
                    }
                    
                    System.out.println("Inserisci password: ");
                    String password2 = scanner2.nextLine();
                    Account account2 = new Account(username2, password2);
                    login.addToAccount(account2);
                    break;
                case 3:
                    System.out.println("Arrivederci!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }

            System.out.print("Vuoi tornare al menu? (si / no)  ");
            risposta = scanner.next();
            if(risposta.equalsIgnoreCase("no")) {
                System.out.println("Arrivederci!");
                System.exit(0);
            }

        } while(risposta.equalsIgnoreCase("si"));
    }
}
