package controller;

import model.service.*;
import model.entity.*;

public class EmploymentCont {

    private static EmploymentCont employmentCont = new EmploymentCont();

    public static EmploymentCont getInstance() {
        return employmentCont;
    }

    private EmploymentCont() {

    }

    public void insert(String name, String fatherName, String id, String educationLevel, String studyField, String phoneNumber, String previousJob, int workExperience) throws Exception {
        EmploymentServ.getInstance().save(new EmploymentEnti().setName(name).setFatherName(fatherName).setId(id).setEducationLevel(educationLevel).setStudyField(studyField).setPhoneNumber(phoneNumber).setPreviousJob(previousJob).setWorkExperience(workExperience));
    }
}
