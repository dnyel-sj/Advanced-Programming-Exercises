package model.service;

import model.entity.*;
import model.repository.*;

public class EmploymentServ {

    private static EmploymentServ employmentServ = new EmploymentServ();

    public static EmploymentServ getInstance() {
        return employmentServ;
    }

    private EmploymentServ() {

    }

    public void save (EmploymentEnti employmentEnti) throws Exception {
        try (EmploymentRepo employmentRepo = new EmploymentRepo()) {
            employmentRepo.insert(employmentEnti);
            employmentRepo.commit ();
        }
    }
}
