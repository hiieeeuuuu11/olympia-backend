package com.example.olympiabackend.model.questions;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "suggest_quest")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class suggest_quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDsuggest;

    @ManyToOne
    @JoinColumn(name = "round2_id")
    @JsonBackReference
    private round2 round2;

    private String question;

    private String answer;

    private int length1;

    @Override
    public String toString() {
        return "suggest_quest{" +
                "IDsuggest=" + IDsuggest +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", length1=" + length1 +
                '}';
    }
}
