package com.example.olympiabackend.model.questions;

import com.example.olympiabackend.model.topic;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="round1")
public class round1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IDquestion;
    String question;
    int level1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idanswer")
    answer_round1 idanswer;

    @ManyToOne
    @JoinColumn(name = "topic")
    topic topic;

}
