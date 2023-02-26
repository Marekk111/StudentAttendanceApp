package com.bakalarka.StudentAttendanceApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private String name;
    private String questionBody;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;


    @JsonManagedReference
    public List<Answer> getAnswers() {
        return answers;
    }

    //public Question(){}

    /*public Question(long id, String name, String questionBody){
        this.id = id;
        this.name = name;
        this.questionBody = questionBody;
    }*/

/*    public long getId(){ return this.id; }
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
    }*/
}
