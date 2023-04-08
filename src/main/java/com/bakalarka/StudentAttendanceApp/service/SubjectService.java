package com.bakalarka.StudentAttendanceApp.service;

import com.bakalarka.StudentAttendanceApp.Exception.SubjectNotFoundException;
import com.bakalarka.StudentAttendanceApp.model.LessonEvent;
import com.bakalarka.StudentAttendanceApp.model.Question;
import com.bakalarka.StudentAttendanceApp.model.Subject;
import com.bakalarka.StudentAttendanceApp.repo.SubjectRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepo subjectRepo;

    @Autowired
    public SubjectService(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    public Subject addSubject(Subject subject) {
        return this.subjectRepo.save(subject);
    }

    public List<Subject> getAllSubjects(){
       List<Subject> subjects = this.subjectRepo.findAll();
       return subjects;
    }

    public Subject findSubjectById(Long id){
        return this.subjectRepo.findSubjectById(id).orElseThrow(() -> new SubjectNotFoundException("Subject by id " + id + " was not found"));
    }

    @Transactional
    public void deleteSubjectById(Long id) {
        this.subjectRepo.deleteSubjectById(id);
    }

    /*public Subject setQuestionForSubject(Long id, Question question) {
        Subject subject = this.findSubjectById(id);
        subject.setQuestion(question);
        return this.subjectRepo.save(subject);
    }

    public Question getQuestionOfSubject(Long id) {
        Subject subject = this.findSubjectById(id);
        return subject.getQuestion();
    }*/

    public List<LessonEvent> getSubjectLessons(Long id) {
        Subject subject = this.findSubjectById(id);
        return subject.getLessons();
    }
}
