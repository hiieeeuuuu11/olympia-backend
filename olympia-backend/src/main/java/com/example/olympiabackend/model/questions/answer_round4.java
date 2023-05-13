package com.example.olympiabackend.model.questions;

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
@Table(name="answer_round4")
public class answer_round4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IDanswer;
    String answer;

    @OneToOne(mappedBy = "idanswer",cascade = CascadeType.ALL)
    round4 round4;
}
