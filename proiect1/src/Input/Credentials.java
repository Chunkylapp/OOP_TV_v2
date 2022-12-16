package Input;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Credentials {
    private String name;
    private String password; //xxhash mfs
    private String accountType;
    private String country;
    private int balance;

    public Credentials(String name, String passowrd, String country, String accountType, int balance) {
        this.name = name;
        this.password = passowrd;
        this.accountType = accountType;
        this.country = country;
        this.balance = balance;
    }

    public Credentials() {
        this.name = "";
        this.password = "";
        this.accountType = "standard";
        this.country = "";
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public String getPassword(){
        return password;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getCountry() {
        return country;
    }

    public int getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPremium(String accountType) {
        this.accountType = accountType;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public ArrayList<String> getCredentials(){
        ArrayList<String> credentials = new ArrayList<String>();
        if(!Objects.equals(name, ""))
            credentials.add(name);
        if(!Objects.equals(password, ""))
            credentials.add(password);
        if(!Objects.equals(accountType, ""))
            credentials.add(accountType);
        if(!Objects.equals(country, ""))
            credentials.add(country);
        if(balance != 0)
            credentials.add(Integer.toString(balance));
        return credentials;
    }
}
