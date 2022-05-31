package controller;

import model.service.*;
import model.entity.*;

import java.util.*;

public class UserAccountCont {

    private static UserAccountCont userAccountCont = new UserAccountCont();

    public static UserAccountCont getInstance() {
        return userAccountCont;
    }

    private UserAccountCont() {

    }

    public void insert(String name, String username, String password, String email) throws Exception {
        UserAccountServ.getInstance().save(new UserAccountEnti().setName(name).setUsername(username).setPassword(password).setEmail(email));
    }

    public void update(String name, String username, String password, String email) throws Exception {
        UserAccountServ.getInstance().edit(new UserAccountEnti().setName(name).setUsername(username).setPassword(password).setEmail(email));
    }

    public boolean select(String username, String password) throws Exception {
        boolean check = false;
        List<UserAccountEnti> userAccountList = UserAccountServ.getInstance().report();
        for (UserAccountEnti userAccountEnti : userAccountList) {
            if(username != null && username.equals(userAccountEnti.getUsername()) && password != null && password.equals(userAccountEnti.getPassword())) {
                check = true;
                break;
            }
        }
        return check;
    }
}
