package com.example.olympiabackend.model.questions;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="answer_round1")
public class answer_round1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IDanswer;
    int iscorrect;
    String A;
    String B;
    String C;
    String D;

    @OneToOne(mappedBy = "idanswer",cascade = CascadeType.ALL)
    @JsonBackReference
    round1 round1;

    @Override
    public String toString() {
        return "answer_round1{" +
                "IDanswer=" + IDanswer +
                ", iscorrect=" + iscorrect +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                '}';
    }
}
