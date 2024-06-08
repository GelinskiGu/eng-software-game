package com.gelinski.engsoftwaregame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "tb_question")
@Getter
@Setter
@JsonIgnoreProperties
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String answer;

    @OneToMany(mappedBy = "question")
    private List<Statement> statement;
}
