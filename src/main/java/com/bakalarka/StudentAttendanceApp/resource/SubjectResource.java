package com.bakalarka.StudentAttendanceApp.resource;

import com.bakalarka.StudentAttendanceApp.model.Question;
import com.bakalarka.StudentAttendanceApp.model.Subject;
import com.bakalarka.StudentAttendanceApp.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectResource {
    private final SubjectService subjectService;

    public SubjectResource(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(this.subjectService.getAllSubjects(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Subject> findSubjectById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.subjectService.findSubjectById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        return new ResponseEntity<>(this.subjectService.addSubject(subject), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject) {
        return new ResponseEntity<>(this.subjectService.addSubject(subject), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable("id") Long id) {
        this.subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*@PutMapping("/find/{id}/setQuestion")
    public ResponseEntity<Subject> setQuestion(@PathVariable("id") Long id, @RequestBody Question question) {
        return new ResponseEntity<>(this.subjectService.setQuestionForSubject(id, question), HttpStatus.OK);
    }

    @GetMapping("find/{id}/question")
    public ResponseEntity<Question> getQuestionOfSubject(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.subjectService.getQuestionOfSubject(id), HttpStatus.OK);
    }*/
}
