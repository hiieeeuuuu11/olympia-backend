package com.example.olympiabackend.model.questions;

import com.example.olympiabackend.model.topic;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "round3")
public class round3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDquestion;

    private String question;

    private String source;

    private int level1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idanswer")
    answer_round3 idanswer;

    @ManyToOne
    @JoinColumn(name = "topicid")
    private topic topic;

    // Getters and setters
}