package com.hemopulse.donor.controller;

import com.hemopulse.donor.model.EmergencyRequest;
import com.hemopulse.donor.repository.EmergencyRequestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/emergency-requests")
@CrossOrigin(origins = "*")
public class EmergencyRequestController {

    private final EmergencyRequestRepository repository;

    public EmergencyRequestController(EmergencyRequestRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<EmergencyRequest>> getAllRequests() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyRequest> getRequestById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmergencyRequest> createRequest(@RequestBody EmergencyRequest request) {
        if (request.getTimeAgo() == null || request.getTimeAgo().trim().isEmpty()) {
            request.setTimeAgo("Just now");
        }
        EmergencyRequest saved = repository.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
