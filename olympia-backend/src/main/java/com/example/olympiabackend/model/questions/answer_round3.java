package com.example.olympiabackend.model.questions;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "answer_round3")
public class answer_round3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDanswer;

    @OneToOne(mappedBy = "idanswer",cascade = CascadeType.ALL)
    @JsonBackReference
    round3 round3;

    private String answer;

}
