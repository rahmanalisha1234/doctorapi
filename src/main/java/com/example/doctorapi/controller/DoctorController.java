package com.example.doctorapi.controller;


import com.example.doctorapi.model.Doctor;
import com.example.doctorapi.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service ;

    @PostMapping("/save")
    public ResponseEntity<Doctor> saveDoctor(@Valid @RequestBody Doctor doctor){
        Doctor savedDoctor = service.saveDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED); // 201
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Doctor>> getAllDoctor(){
        List<Doctor> getAll = service.getAllDoctors();
        return new ResponseEntity<>(getAll,HttpStatus.OK); // 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        Doctor getById = service.getDoctorsById(id);
        if(getById != null){
            return new ResponseEntity<>(getById,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Unable to find doctor with the given id: " + id , HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id ,@RequestBody Doctor doctor){
        Doctor getById = service.getDoctorsById(id);
        if(getById != null){
            doctor.setId(id);
            Doctor updatedDoctor = service.updateDoctor(doctor);
            return new ResponseEntity<>(updatedDoctor,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Unable to find doctor with the given id: " + id , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        Doctor getById = service.getDoctorsById(id);
        if(getById != null){
            service.deleteDoctor(id);
            return new ResponseEntity<>("Doctor with id " + id + " has been deleted successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Unable to find doctor with the given id: " + id , HttpStatus.NOT_FOUND);
        }


    }



}
