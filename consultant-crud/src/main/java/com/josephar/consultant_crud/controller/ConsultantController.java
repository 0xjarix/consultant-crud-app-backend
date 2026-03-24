package com.josephar.consultant_crud.controller;

import com.josephar.consultant_crud.dto.ConsultantDTO;
import com.josephar.consultant_crud.model.Consultant;
import com.josephar.consultant_crud.service.ConsultantMapper;
import com.josephar.consultant_crud.service.ConsultantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultants")
@CrossOrigin
public class ConsultantController {

    private final ConsultantService service;

    public ConsultantController(ConsultantService service) {
        this.service = service;
    }

    // GET all consultants
    @GetMapping
    public List<ConsultantDTO> getAll() {
        return service.findAll()
                .stream()
                .map(ConsultantMapper::toDTO)
                .toList();
    }

    // GET one consultant
    @GetMapping("/{id}")
    public ConsultantDTO getById(@PathVariable Long id) {
        return ConsultantMapper.toDTO(service.findById(id));
    }

    // CREATE
    @PostMapping
    public ConsultantDTO create(@RequestBody @Valid ConsultantDTO dto) {
        Consultant saved = service.save(ConsultantMapper.toEntity(dto));
        return ConsultantMapper.toDTO(saved);
    }

    // UPDATE
    @PatchMapping("/{id}")
    public ConsultantDTO update(@PathVariable Long id, @RequestBody @Valid ConsultantDTO dto) {
        Consultant existing = service.findById(id);

        // Only update fields that are not null (for PATCH behavior)
        if (dto.getFirstName() != null) existing.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) existing.setLastName(dto.getLastName());
        if (dto.getEmail() != null) existing.setEmail(dto.getEmail());
        if (dto.getExpertise() != null) existing.setExpertise(dto.getExpertise());
        if (dto.getAge() != 0) existing.setAge(dto.getAge());

        Consultant updated = service.save(existing);
        return ConsultantMapper.toDTO(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}