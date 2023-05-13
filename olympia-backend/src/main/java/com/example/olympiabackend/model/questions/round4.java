package com.example.olympiabackend.model.questions;


import com.example.olympiabackend.model.topic;
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
@Table(name="round4")
public class round4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IDquestion;
    String question;
    String source;
    int level1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idanswer")
    answer_round4 idanswer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topicid")
    topic topic;

}
