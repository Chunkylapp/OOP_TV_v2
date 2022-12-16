package Input;

import java.util.ArrayList;

public class UserInput {

    private Credentials credentials;
    // new array list of strings for premium movies

    public UserInput(String name, String passowrd, String country, String accountType,int balance) {
        this.credentials = new Credentials(name, passowrd, country, accountType, balance);
    }

    public UserInput() {
        this.credentials = new Credentials();
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
