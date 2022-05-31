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

    public void save (UserAccountEnti userAccountEnti) throws Exception {
        try (UserAccountRepo userAccountRepo = new UserAccountRepo()) {
            userAccountRepo.insert(userAccountEnti);
            userAccountRepo.commit ();
        }
    }

    public void edit (UserAccountEnti userAccountEnti) throws Exception {
        try (UserAccountRepo userAccountRepo = new UserAccountRepo()){
            userAccountRepo.update(userAccountEnti);
            userAccountRepo.commit();
        }
    }

    public List<UserAccountEnti> report() throws Exception {
        List<UserAccountEnti> userAccountEntis;
        try(UserAccountRepo userAccountRepo = new UserAccountRepo()) {
            userAccountEntis = userAccountRepo.select ();
        }
        return userAccountEntis;
    }
}
