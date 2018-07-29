package sgrrustudentmanagement;

import java.util.Date;

public class Student {
    private int studentId;
    private String name;
    private String fName;
    private String mName;
    private Date DOB;
    private String gender;
    private String nationality;
    private String category;
    private String email;
    private String mobileNumber;
    private String address;
    private String course;
    private int total;
    private int paid;
    private int balance;

    public Student() {
    }

    public Student(int studentId, String name, String fName, String mName, String gender, Date DOB, String nationality, String category, String mobileNumber, String email,  String address, String course) {
        this.studentId = studentId;
        this.name = name;
        this.fName = fName;
        this.mName = mName;
        this.DOB = DOB;
        this.gender = gender;
        this.nationality = nationality;
        this.category = category;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.course = course;
    }

    public Student(int studentId, int total, int paid, int balance){
        this.studentId = studentId;
        this.total = total;
        this.paid = paid;
        this.balance = balance;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    
    
    
}
