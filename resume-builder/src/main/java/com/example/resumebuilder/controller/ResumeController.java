package com.example.resumebuilder.controller;

import com.example.resumebuilder.model.Resume;
import com.example.resumebuilder.service.ResumeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping("/uploadResumeDetails")
    public ResponseEntity<Long> uploadResumeDetails(@Valid @RequestBody Resume resume){
        Resume generatedResume = resumeService.save(resume);
        if(generatedResume == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(generatedResume.getId());
    }

    @GetMapping("/getResumeById/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable Long id){
        Optional<Resume> resume  = resumeService.getById(id);
        return resume.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getResumeByName/{name}")
    public ResponseEntity<List<Resume>> getResumeByName(@PathVariable String name){
        List<Resume> resumes = resumeService.findByName(name);
        if(resumes.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resumes);
    }
}
