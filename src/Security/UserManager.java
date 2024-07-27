package Security;

import Model.LoginContext;

import java.util.ArrayList;


public class UserManager {
    private ArrayList<LoginContext> users;
    private LoginContext currentUser;
    public UserManager() {
        users = new ArrayList<>();
        currentUser = null;
    }


    public boolean registerUser(String username, String password) {
        if(findUserByName(username)!=null){
            return false;
        }
        users.add(new LoginContext(username, password));
        return true;
    }

    public boolean getLoginCredentials(String username, String password) {
        LoginContext user = findUser(username, password);
        if(user!=null){
            currentUser = user;
            return true;
        }
        return false;
    }

    public void logoutUser(){
        currentUser = null;
    }

    private LoginContext findUser(String username,String password) {
        for(LoginContext user: users){
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    private LoginContext findUserByName(String username) {
        for(LoginContext user: users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public ArrayList<LoginContext> getAll(){
        return users;
    }
}
