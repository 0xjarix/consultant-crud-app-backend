package com.josephar.consultant_crud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String expertise;
}