package user;

import Input.UserInput;

public class UserFactory {

    public static UserInterface getUser(UserInput userInput) {
        if (userInput.getCredentials().getAccountType().equals("standard")) {
            return new StandardUser(userInput.getCredentials().getName(), userInput.getCredentials().getPassword(),
                    userInput.getCredentials().getAccountType(),
                    userInput.getCredentials().getCountry(), userInput.getCredentials().getBalance());
        }
        if (userInput.getCredentials().getAccountType().equals("premium")) {
            return new PremiumUser(userInput.getCredentials().getName(), userInput.getCredentials().getPassword(),
                    userInput.getCredentials().getAccountType(),
                    userInput.getCredentials().getCountry(), userInput.getCredentials().getBalance());
        }
        return null;
    }
    public static UserInterface getUser(String name, String password, String accountType, String country, int balance) {
        if (accountType.equals("standard")) {
            return new StandardUser(name, password, accountType, country, balance);
        }
        if (accountType.equals("premium")) {
            return new PremiumUser(name, password, accountType, country, balance);
        }
        return null;
    }
}
