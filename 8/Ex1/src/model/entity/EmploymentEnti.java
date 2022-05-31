package model.entity;

public class EmploymentEnti {
    private String name;
    private String fatherName;
    private String id;
    private String educationLevel;
    private String studyField;
    private String phoneNumber;
    private String previousJob;
    private int workExperience;

    public EmploymentEnti() {

    }

    public EmploymentEnti(String name, String fatherName, String id, String educationLevel, String studyField, String phoneNumber, String previousJob, int workExperience) {
        this.name = name;
        this.fatherName = fatherName;
        this.id = id;
        this.educationLevel = educationLevel;
        this.studyField = studyField;
        this.phoneNumber = phoneNumber;
        this.previousJob = previousJob;
        this.workExperience = workExperience;
    }

    public String getName() {
        return name;
    }

    public EmploymentEnti setName(String name) {
        this.name = name;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public EmploymentEnti setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getId() {
        return id;
    }

    public EmploymentEnti setId(String id) {
        this.id = id;
        return this;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public EmploymentEnti setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getStudyField() {
        return studyField;
    }

    public EmploymentEnti setStudyField(String studyField) {
        this.studyField = studyField;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public EmploymentEnti setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPreviousJob() {
        return previousJob;
    }

    public EmploymentEnti setPreviousJob(String previousJob) {
        this.previousJob = previousJob;
        return this;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public EmploymentEnti setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
        return this;
    }
}
