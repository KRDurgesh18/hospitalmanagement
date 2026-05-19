package com.stackly1.hospitalmanagementssystem.dto1.request;

public class Doctorrequest {
    private String name;
    private String specialization;
    private String email;
    private String phone;
    private String department;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String s) { this.specialization = s; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getDepartment() { return department; }
    public void setDepartment(String d) { this.department = d; }
}