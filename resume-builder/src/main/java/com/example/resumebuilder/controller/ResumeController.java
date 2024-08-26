package com.example.resumebuilder.controller;

import com.example.resumebuilder.model.Resume;
import com.example.resumebuilder.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping("/uploadResumeDetails")
    public Long uploadResumeDetails(@RequestBody Resume resume){
        Resume generatedResume = resumeService.save(resume);
        return generatedResume.getId();
    }

    @GetMapping("/getResumeById/{id}")
    public Optional<Resume> getResumeById(@PathVariable Long id){
        return resumeService.getById(id);
    }

    @GetMapping("/getResumeByName/{name}")
    public List<Resume> getResumeByName(@PathVariable String name){
        return resumeService.findByName(name);
    }
}
