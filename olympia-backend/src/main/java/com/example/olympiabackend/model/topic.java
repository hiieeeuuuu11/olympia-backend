package com.example.olympiabackend.model;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round4;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="topic")
public class topic{

    @Id
    int topicid;

    String topic;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question",referencedColumnName = "topicid")
    private List<round1> round1;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question",referencedColumnName = "topicid")
    private List<round4> round4;


    
}
