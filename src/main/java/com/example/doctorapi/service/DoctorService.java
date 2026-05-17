package com.example.doctorapi.service;

import com.example.doctorapi.exception.ResourceNotFoundException;
import com.example.doctorapi.model.Doctor;
import com.example.doctorapi.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor saveDoctor(Doctor doctor){
        return repository.save(doctor);
    }

    public List<Doctor> getAllDoctors(){
        return repository.findAll();
    }

    public Doctor getDoctorsById(int id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found by given id " + id));
    }

    public Doctor updateDoctor(Doctor doctor){
        return repository.save(doctor);
    }

    public void deleteDoctor(int id){
        repository.deleteById(id);
    }

}
