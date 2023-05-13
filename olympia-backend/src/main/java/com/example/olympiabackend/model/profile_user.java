package com.example.olympiabackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="profile_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class profile_user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String firstname;
    String lastname;
    Date dob;
    String gmail;
    int role1;
    String description1;


}