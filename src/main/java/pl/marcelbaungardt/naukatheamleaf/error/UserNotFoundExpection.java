package pl.marcelbaungardt.naukatheamleaf.error;

public class UserNotFoundExpection extends RuntimeException{
    public UserNotFoundExpection() {
        super("User not found! Fatal Error 404");
    }
}
