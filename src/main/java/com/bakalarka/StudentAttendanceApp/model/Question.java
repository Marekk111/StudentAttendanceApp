package com.bakalarka.StudentAttendanceApp.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private long id;
    private String name;
    private String questionBody;

    public Question(){}

    public Question(long id, String name, String questionBody){
        this.id = id;
        this.name = name;
        this.questionBody = questionBody;
    }

    public long getId(){ return this.id; }
    public String getName() { return this.name; }
    public String getQuestionBody() { return this.questionBody; }

    public void setId( long id) { this.id = id;}
    public void setName(String name) { this.name = name; }
    public void setQuestionBody(String questionBody) { this.questionBody = questionBody; }

    @Override
    public String toString(){
        return "Question{" +
                "id=" + this.id +
                "name=" + this.name + "\'" +
                "body=" + this.questionBody + "\'" +
                "}";
    }
}
