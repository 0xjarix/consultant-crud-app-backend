// src/main/java/com/josephar/consultant_crud/service/ConsultantMapper.java
package com.josephar.consultant_crud.service;

import com.josephar.consultant_crud.dto.ConsultantDTO;
import com.josephar.consultant_crud.model.Consultant;

public class ConsultantMapper {

    public static ConsultantDTO toDTO(Consultant consultant) {
        return new ConsultantDTO(
                consultant.getId(),
                consultant.getFirstName(),
                consultant.getLastName(),
                consultant.getEmail(),
                consultant.getExpertise(),
                consultant.getAge()
        );
    }

    public static Consultant toEntity(ConsultantDTO dto) {
        Consultant c = new Consultant();
        c.setId(dto.getId());
        c.setFirstName(dto.getFirstName());
        c.setLastName(dto.getLastName());
        c.setEmail(dto.getEmail());
        c.setExpertise(dto.getExpertise());
        c.setAge(dto.getAge());
        return c;
    }
}