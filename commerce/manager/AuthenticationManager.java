package commerce.manager;

import commerce.user.User;

public class AuthenticationManager {
    private static User loggedInUser;

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static boolean isAuthenticated() {
        return loggedInUser != null;
    }

    public static double getBalance() {
        if (loggedInUser != null) {
            return loggedInUser.getBalance();
        }
        return 0.0; // Return 0 if user is not authenticated
    }

    public static boolean subtractBalance(double amount) {
        if (loggedInUser != null && loggedInUser.getBalance() >= amount) {
            loggedInUser.setBalance(loggedInUser.getBalance() - amount);
            return true; // Balance subtracted successfully
        }
        return false; // Insufficient balance or user not authenticated
    }

    public static void logout() {
        loggedInUser = null;
    }
}
