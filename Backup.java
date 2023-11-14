import java.util.HashMap;
import java.io.*;

public class Backup {
    private static String path = "C:\\Users\\ninoa\\Desktop\\ELIS 23-24\\JavaWeb\\Progetto1\\backup.txt";

    public static HashMap readBackup(){
        HashMap<Integer, Account> accounts = new HashMap<>();
        try(FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr)){
            
            Login login = Login.LoginClass();
            
            String line;
            while((line = br.readLine()) != null){
                String[] splitted = line.split(";");
                //username;password;nome;cognome;email;id
                Account account = new Account(splitted[0], splitted[1]);
                account.setNome(splitted[2]);
                account.setCognome(splitted[3]);
                account.setEmail(splitted[4]);
                account.setIndirizzo(splitted[5]);
                account.setId(login.getCounter());
                accounts.put(login.getCounter(), account);
                login.setCounter(login.getCounter()+1);
            }
            
        } catch(IOException e){
            System.out.println("Errore nella lettura del file");
        }

        return accounts;
    }
}
