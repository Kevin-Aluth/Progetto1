import java.util.HashMap;
import java.io.*;

public class Backup {
    private static String path = "backup.txt";

    public static HashMap readBackup(){
        HashMap<Integer, Account> accounts = new HashMap<>();
        try(FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr)){
            
            Login login = Login.LoginClass();
            int lastId = 1; 
            
            String line;
            while((line = br.readLine()) != null){
                String[] splitted = line.split(";");
                //username;password;nome;cognome;email;indirizzo;id
                Account account = new Account(splitted[0], splitted[1]);
                account.setNome(splitted[2]);
                account.setCognome(splitted[3]);
                account.setEmail(splitted[4]);
                account.setIndirizzo(splitted[5]);
                account.setId(Integer.parseInt(splitted[6]));
                accounts.put(Integer.parseInt(splitted[6]), account);
                lastId = (Integer.parseInt(splitted[6])+1);
            }
            login.setCounter(lastId);
            
        } catch(IOException e){
            System.out.println("Errore nella lettura del file");
        }

        return accounts;
    }

    public static void removeFromBackup(int id)
    {
        String content = "";
        try(FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr)){
            
            String line;
            while((line = br.readLine()) != null){
                String[] splitted = line.split(";");
                //username;password;nome;cognome;email;indirizzo;id
                if(Integer.parseInt(splitted[6]) != id)content+=line+"\n"; 
            }
        } catch(IOException e){
            System.out.println("Errore nella lettura del file");
        }

        try(FileWriter fw = new FileWriter(path); 
        BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(content);
        } catch(IOException e){
            System.out.println("Errore nella lettura dei file");
        }
    }

    public static void saveToBackup(Account account){
        String toWrite = ""; 
        toWrite+=account.getUsername() + ";"; 
        toWrite+=account.getPassword() + ";";
        toWrite+=account.getNome() + ";"; 
        toWrite+=account.getCognome() + ";";
        toWrite+=account.getEmail() + ";"; 
        toWrite+=account.getIndirizzo() + ";";
        toWrite+=account.getId() + ";"; 
        
        try(FileWriter fw = new FileWriter(path, true); 
        BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(toWrite);
        } catch(IOException e){
            System.out.println("Errore nella lettura dei file");
        }
    }

    public static void updateAccount(Account account){
        String content = "";
        try(FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr)){
            
            String line;
            while((line = br.readLine()) != null){
                String[] splitted = line.split(";");
                //username;password;nome;cognome;email;indirizzo;id
                if(Integer.parseInt(splitted[6]) != account.getId()){
                    content+=line+"\n"; 
                } else{
                    String stringToChange = account.getUsername() + ";" + account.getPassword() + ";" + account.getNome() + ";" + account.getCognome() + ";" + 
                    account.getEmail() + ";" + account.getIndirizzo() + ";" + account.getId();
                    content+=stringToChange+"\n"; 
                }
            }
        } catch(IOException e){
            System.out.println("Errore nella lettura del file");
        }

        try(FileWriter fw = new FileWriter(path); 
        BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(content);
        } catch(IOException e){
            System.out.println("Errore nella lettura dei file");
        }
    }
}
