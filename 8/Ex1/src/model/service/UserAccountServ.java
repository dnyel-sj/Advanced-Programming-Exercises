package model.service;

import model.entity.*;
import model.repository.*;

import java.util.*;

public class UserAccountServ {

    private static UserAccountServ userAccountServ = new UserAccountServ();

    public static UserAccountServ getInstance() {
        return userAccountServ;
    }

    private UserAccountServ() {

    }

    public List<UserAccountEnti> report() throws Exception {
        List<UserAccountEnti> userAccountEntis;
        try(UserAccountRepo userAccountRepo = new UserAccountRepo()) {
            userAccountEntis = userAccountRepo.select ();
        }
        return userAccountEntis;
    }
}
