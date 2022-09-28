package com.example.RegistryWeb.service;

import com.example.RegistryWeb.models.Person;
import com.example.RegistryWeb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> listAll(){
        return personRepository.findAll();
    }

    public void save(Person person){
        personRepository.save(person);
    }

    public Person getById(Long id){
        return personRepository.findById(id).get();
    }

    public void delete(Long id){
        personRepository.deleteById(id);
    }

    public List<Person> getByKeyword(String keyword){
        return personRepository.findByKeyword(keyword);
    }
}
