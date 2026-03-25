package com.josephar.consultant_crud.controller;

import com.josephar.consultant_crud.dto.ConsultantDTO;
import com.josephar.consultant_crud.dto.CreateConsultantRequest;
import com.josephar.consultant_crud.dto.UpdateConsultantRequest;
import com.josephar.consultant_crud.model.Consultant;
import com.josephar.consultant_crud.service.ConsultantMapper;
import com.josephar.consultant_crud.service.ConsultantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<ConsultantDTO> getAll(@RequestParam(required = false) String search) {
        return service.findAll(search)
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
    public ResponseEntity<ConsultantDTO> create(@RequestBody @Valid CreateConsultantRequest request) {
        Consultant saved = service.save(ConsultantMapper.toEntity(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(ConsultantMapper.toDTO(saved));
    }

    // UPDATE
    @PatchMapping("/{id}")
    public ConsultantDTO update(@PathVariable Long id, @RequestBody @Valid UpdateConsultantRequest request) {
        Consultant existing = service.findById(id);
        ConsultantMapper.applyUpdate(existing, request);

        Consultant updated = service.save(existing);
        return ConsultantMapper.toDTO(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}