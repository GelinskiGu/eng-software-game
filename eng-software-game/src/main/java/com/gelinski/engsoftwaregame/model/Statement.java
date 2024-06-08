package com.gelinski.engsoftwaregame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_statement")
@Getter
@Setter
@JsonIgnoreProperties({"question"})
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String statementDescription;

    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;
}
