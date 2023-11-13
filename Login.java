import java.util.ArrayList;

public class Login {
    ArrayList<Account> accounts = new ArrayList<>();
    Login instance = null; 

    private Login(){}
    public Login LoginClass()
    {
        if(instance == null)
        {
            instance = this; 
        }
        return instance;
    }

    public Account checkLogin(String username, String password)
    {
        Account activeAccount = null;  
        
        for(int i = 0; i < accounts.size(); i++)
        {
            if(accounts.get(i).getUsername() == username)
            {
                activeAccount = accounts.get(i); 
                break; 
            }
        }
        if(activeAccount == null) return null; 
        if(activeAccount.getPassword() != password)
        {
            return null; 
        }
        return activeAccount; 
    }
}
