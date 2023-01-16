package input;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class implements the credentials of a user
 */
public class Credentials {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private int balance;

    /**
     * Constructor
     *
     * @param name        name of the user
     * @param passowrd    password of the user
     * @param country     country of the user
     * @param accountType account type of the user
     * @param balance     balance of the user
     */
    public Credentials(final String name, final String passowrd,
                       final String country, final String accountType, final int balance) {
        this.name = name;
        this.password = passowrd;
        this.accountType = accountType;
        this.country = country;
        this.balance = balance;
    }

    /**
     * Default constructor
     */
    public Credentials() {
        this.name = "";
        this.password = "";
        this.accountType = "standard";
        this.country = "";
        this.balance = 0;
    }

    /**
     * Name getter
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Password getter
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Account type getter
     *
     * @return accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Country getter
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Balance getter
     *
     * @return balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Name setter
     *
     * @param name name of the user
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Password setter
     *
     * @param password password of the user
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Account type setter
     *
     * @param accountType account type of the user
     */
    public void setPremium(final String accountType) {
        this.accountType = accountType;
    }

    /**
     * Country setter
     *
     * @param country country of the user
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * Balance setter
     *
     * @param balance balance of the user
     */
    public void setBalance(final int balance) {
        this.balance = balance;
    }

    /**
     * Method returns the string representation of the object
     *
     * @return string representation of the object
     */
    public ArrayList<String> getCredentials() {
        ArrayList<String> credentials = new ArrayList<String>();
        if (!Objects.equals(name, "")) {
            credentials.add(name);
        }
        if (!Objects.equals(password, "")) {
            credentials.add(password);
        }
        if (!Objects.equals(accountType, "")) {
            credentials.add(accountType);
        }
        if (!Objects.equals(country, "")) {
            credentials.add(country);
        }
        if (balance != 0) {
            credentials.add(Integer.toString(balance));
        }
        return credentials;
    }
}
