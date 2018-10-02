package com.forze.sa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PersonController {
    @Autowired
    BloodTypeRepository bloodTypeRepository;
    @Autowired
    GenderRepository genderRepository;
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/gender")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<GenderEntity> getAllGender(){
        return genderRepository.findAll();
    }

    @GetMapping("/blood")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<BloodTypeEntity> getAllBloodType(){
        return bloodTypeRepository.findAll();
    }

    @PostMapping("/person/{blood}/{gender}")
    @CrossOrigin(origins = "http://localhost:4200")
    public PersonEntity newPerson(@RequestBody PersonEntity newPerson, @PathVariable String blood, @PathVariable String gender){
        PersonEntity p = new PersonEntity();
        BloodTypeEntity bloodType = bloodTypeRepository.findByName(blood);
        GenderEntity gen = genderRepository.findByName(gender);
        p.setName(newPerson.getName());
        p.setAge(newPerson.getAge());
        p.setBloodType(bloodType);
        p.setGender(gen);
        return this.personRepository.save(p);
    }
}
