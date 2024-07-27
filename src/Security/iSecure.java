package Security;

import java.util.ArrayList;

public interface iSecure<S> {
    void addNewCredentials(String account, String password);
    void removeUser(String username);
    S getCredentials(String username, String password);
    S getUser(String username);

}