package com.josephar.consultant_crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultantDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String expertise;

    private Integer age;
}
