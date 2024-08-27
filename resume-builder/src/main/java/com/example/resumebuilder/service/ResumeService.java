package com.example.resumebuilder.service;

import com.example.resumebuilder.model.Resume;
import com.example.resumebuilder.repository.ResumeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepo resumeRepo;

    public Resume save(Resume resume){
        try{
            return resumeRepo.save(resume);
        }
        catch (Exception exception){
            System.out.println("Error in saving resume details: " + exception);
            return null;
        }
    }

    public Optional<Resume> getById(Long id){
        return resumeRepo.findById(id);
    }

    public List<Resume> findByName(String name){
        try {
            String[] fullName = name.split("\\+");
            String firstName = fullName[0];
            String lastName = fullName[1];
            List<Resume> fullMatch = resumeRepo.findByFirstNameAndLastName(firstName, lastName);

            if(fullMatch.isEmpty()){
                Set<Resume> matches = new HashSet<>();
                matches.addAll(resumeRepo.findByFirstName(firstName));
                matches.addAll(resumeRepo.findByLastName(lastName));

                return List.copyOf(matches);
            }
            return fullMatch;
        }
        catch (Exception exception){
            System.out.println("Error in finding by name: " + exception);
            return Collections.emptyList();
        }
    }
}
