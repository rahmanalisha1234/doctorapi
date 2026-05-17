package com.example.doctorapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// This is a model class

@Entity
@Table(name="DoctorTable")
public class Doctor {
    @Id
    @Column(name="doctor_id")
    private int id;
    @Column(name="doctor_name")
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Column(name="doctor_department")
    private String department;
    @Column(name="doctor_email")
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid Email format")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@gmail\\.com$",
            message = "Only Gmail addresses are allowed"
    )
    private String email;

    public Doctor(){

    }

    public Doctor(int id , String name, String department , String email){
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }


}
