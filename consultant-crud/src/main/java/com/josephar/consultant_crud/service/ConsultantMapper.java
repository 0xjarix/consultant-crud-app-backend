package com.josephar.consultant_crud.service;

import com.josephar.consultant_crud.dto.ConsultantDTO;
import com.josephar.consultant_crud.dto.CreateConsultantRequest;
import com.josephar.consultant_crud.dto.UpdateConsultantRequest;
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

    public static Consultant toEntity(CreateConsultantRequest request) {
        Consultant c = new Consultant();
        c.setFirstName(normalizeText(request.getFirstName()));
        c.setLastName(normalizeText(request.getLastName()));
        c.setEmail(normalizeEmail(request.getEmail()));
        c.setExpertise(normalizeText(request.getExpertise()));
        c.setAge(request.getAge());
        return c;
    }

    public static void applyUpdate(Consultant consultant, UpdateConsultantRequest request) {
        if (request.getFirstName() != null) consultant.setFirstName(normalizeText(request.getFirstName()));
        if (request.getLastName() != null) consultant.setLastName(normalizeText(request.getLastName()));
        if (request.getEmail() != null) consultant.setEmail(normalizeEmail(request.getEmail()));
        if (request.getExpertise() != null) consultant.setExpertise(normalizeText(request.getExpertise()));
        if (request.getAge() != null) consultant.setAge(request.getAge());
    }

    private static String normalizeText(String value) {
        return value == null ? null : value.trim();
    }

    private static String normalizeEmail(String value) {
        return value == null ? null : value.trim().toLowerCase();
    }
}
