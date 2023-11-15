class Account {
    private String username; 
    private String password;
    private int id = 0; 
    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;

    public Account(String username, String password){
        this.username=username;
        this.password=password;
        nome = " "; 
        cognome = " "; 
        email = " "; 
        indirizzo = " "; 
    }

    public int getId(){
        return id; 
    } public void setId(int value){
        if(id == 0)id = value; 
    }

    public String getUsername(){
        return username;

    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public String getEmail(){
        return email;
    }

    public String getIndirizzo(){
        return indirizzo;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setCognome(String cognome){
        this.cognome=cognome;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setIndirizzo(String indirizzo){
        this.indirizzo=indirizzo;
    }

    public boolean CheckUsernamePassword(String username, String password){
        if(username.equals(this.username) && password.equals(this.password)){
            return true;
        } else{
            return false;
        }
        
    }

    @Override
    public String toString(){
        return username; 
    }
}
