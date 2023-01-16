package user;

import input.UserInput;

/**
 * Class UserFactory implements a factory for users
 */
public final class UserFactory {

    private UserFactory() {
        // empty constructor
    }

    /**
     * Method createUser creates a user based on the input
     * @param userInput an object of type UserInput
     * @return user a UserInterface object
     */
    public static UserInterface getUser(final UserInput userInput) {
        if (userInput.getCredentials().getAccountType().equals("standard")) {
            return new StandardUser(userInput.getCredentials().getName(),
                    userInput.getCredentials().getPassword(),
                    userInput.getCredentials().getAccountType(),
                    userInput.getCredentials().getCountry(),
                    userInput.getCredentials().getBalance());
        }
        if (userInput.getCredentials().getAccountType().equals("premium")) {
            return new PremiumUser(userInput.getCredentials().getName(),
                    userInput.getCredentials().getPassword(),
                    userInput.getCredentials().getAccountType(),
                    userInput.getCredentials().getCountry(),
                    userInput.getCredentials().getBalance());
        }
        return null;
    }

    /**
     * Method createUser creates a user based on the input
     * @param name the name of the user
     * @param password the password of the user
     * @param accountType the account type of the user
     * @param country the country of the user
     * @param balance the balance of the user
     * @return user a UserInterface object
     */
    public static UserInterface getUser(final String name, final String password,
                                        final String accountType, final String country,
                                        final int balance) {
        if (accountType.equals("standard")) {
            return new StandardUser(name, password, accountType, country, balance);
        }
        if (accountType.equals("premium")) {
            return new PremiumUser(name, password, accountType, country, balance);
        }
        return null;
    }
}
