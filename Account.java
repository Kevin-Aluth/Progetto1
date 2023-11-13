class Account {
    private String username; 
    private String password;
    private int id;
    public static int idProgressivo = 1;

    public Account(String username, String password, int id){
        this.username=username;
        this.password=password;
        this.id=idProgressivo;
        idProgressivo++;
    }

    public String getUsername(){
        return username;

    }

    public String getPassword(){
        return password;
    }

    public int getId(){
        return id;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public boolean CheckUsernamePassword(String username, String password){
        if(username.equals(this.username) && password.equals(this.password)){
            return true;
        } else{
            return false;
        }
        
    }
}
