package input;

/**
 * Class UserInput implements the input for the user
 * it holds a credentials object
 */
public class UserInput {

    private Credentials credentials;

    /**
     * Constructor
     * @param name user's username
     * @param passowrd user's password
     * @param country user's country
     * @param accountType user's account type
     * @param balance user's balance
     */
    public UserInput(final String name, final String passowrd,
                     final String country, final String accountType,
                     final int balance) {
        this.credentials = new Credentials(name, passowrd, country, accountType, balance);
    }

    /**
     * Default constructor
     */
    public UserInput() {
        this.credentials = new Credentials();
    }

    /**
     * Credentials getter
     * @return credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * Credentials setter
     * @param credentials
     */
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }
}
