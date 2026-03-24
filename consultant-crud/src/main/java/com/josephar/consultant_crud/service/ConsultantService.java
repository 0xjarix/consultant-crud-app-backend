package com.josephar.consultant_crud.service;

import com.josephar.consultant_crud.exception.ResourceNotFoundException;
import com.josephar.consultant_crud.exception.AlreadyExistsException;
import com.josephar.consultant_crud.model.Consultant;
import com.josephar.consultant_crud.repository.ConsultantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultantService {

    private final ConsultantRepository repository;

    public ConsultantService(ConsultantRepository repository) {
        this.repository = repository;
    }

    public List<Consultant> findAll() {
        return repository.findAll();
    }

    public Consultant save(Consultant consultant) {

        var existing = repository.findByEmail(consultant.getEmail());

        if (existing.isPresent() && !existing.get().getId().equals(consultant.getId())) {
            throw new AlreadyExistsException(
                    "Consultant with email " + consultant.getEmail() + " already exists"
            );
        }

        return repository.save(consultant);
    }

    public Consultant findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consultant not found with id " + id));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete: Consultant not found with id " + id);
        }
        repository.deleteById(id);
    }
}