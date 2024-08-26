package com.example.resumebuilder.service;

import com.example.resumebuilder.model.Resume;
import com.example.resumebuilder.repository.ResumeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepo resumeRepo;

    public Resume save(Resume resume){
        return resumeRepo.save(resume);
    }

    public Optional<Resume> getById(Long id){
        return resumeRepo.findById(id);
    }

    public List<Resume> findByName(String name){
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
}
