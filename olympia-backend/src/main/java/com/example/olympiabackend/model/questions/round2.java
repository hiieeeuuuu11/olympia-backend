package com.example.olympiabackend.model.questions;

import com.example.olympiabackend.model.topic;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "round2")
@Data
@Transactional
@NoArgsConstructor
@AllArgsConstructor
public class round2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDquestion;

    private String title;

    private String Picture_source;

    private String keyword;

    @ManyToOne
    @JoinColumn(name = "topicid")
    private topic topic;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "round2_id",referencedColumnName = "IDquestion")
    private List<suggest_quest> suggest;

    @Override
    public String toString() {
        return "round2{" +
                "IDquestion=" + IDquestion +
                ", title='" + title + '\'' +
                ", Picture_source='" + Picture_source + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}