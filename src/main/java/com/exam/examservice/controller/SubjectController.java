package com.exam.examservice.controller;


import com.exam.examservice.controller.errors.ResourceNotFoundException;
import com.exam.examservice.dto.SubjectDTO;
import com.exam.examservice.entities.Subject;
import com.exam.examservice.repository.ExamRepo;
import com.exam.examservice.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SubjectController {

    @Autowired
    ExamRepo examRepo;

    @Autowired
    SubjectRepo subjectRepo;

    @PostMapping("/subject")
    public ResponseEntity<EntityModel<Subject>> postSubject(@RequestBody @Valid SubjectDTO subjectDTO){
        Subject subject = new Subject(subjectDTO.getName(), subjectDTO.getCreditPoints(), subjectDTO.getProfessor(),
                subjectDTO.getGroupId());
        subjectRepo.save(subject);
        EntityModel<Subject> entityModel = EntityModel.of(subject);
        WebMvcLinkBuilder linkBuilder =WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getSubjectById(0));
        entityModel.add(linkBuilder.withRel("getSubjectById"));
        return new ResponseEntity<>(entityModel, HttpStatus.CREATED);
    }

    @GetMapping("/subject/{subjectId}")
    public EntityModel<Subject> getSubjectById(@PathVariable int subjectId){
        Optional<Subject> subject = subjectRepo.findById(subjectId);
        if(!subject.isPresent())
            throw new ResourceNotFoundException(String.format("There is no subject inside the database with the id %d", subjectId));
        EntityModel<Subject> entityModel = EntityModel.of(subject.get());
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).postSubject(null));
        entityModel.add(linkBuilder.withRel("postSubject"));
        return entityModel;
    }

}
