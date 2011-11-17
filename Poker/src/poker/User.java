/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author siesiek
 */
public class User {
    private String username;
    private String login;
    private String password;
    private int id;
    private int deleted;
    
    public User(int id){
        this.id = id;
    }
    
    public User(String login, String password){
        this.login = login;
        this.password = password;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    
    /**
     * Metoda "usuwajaca" z bazy uzytkownika, ustawia flage deleted na 1 i uaktualnia baze danych
     * @todo aktualizacja bazy danych
     */
    public void deleteUser(){
        this.deleted = 1;
    }
    
    public int getId(){
        return this.id;
    }
    
    /**
     * Metoda logowania uzytkownika
     * @todo wszystko co potrzebne do logowania i aktualizacja danych w bazie
     */
    public void loginUser(){
        
    }
    
    /**
     * Metoda rejestracji uzytkownika
     * @todo wszystko co potrzebne do rejestracji i aktualizacja danych w bazie
     */
    public void registerUser(){
        
    }
    
    /**
     * Metoda wczytujaca uzytkownika z bazy danych
     */
    public void loadUser(){
        
    }
    
    /**
     * Metoda zapisujaca nowe dane o uzytkowniku
     */
    public void saveUser(){
        
    }
}
