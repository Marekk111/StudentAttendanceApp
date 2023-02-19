package com.bakalarka.StudentAttendanceApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Answer {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    //private User answeringUser;
    @ManyToOne(fetch = FetchType.LAZY)
    private Question sourceQuestion;
    private String answerBody;

}
