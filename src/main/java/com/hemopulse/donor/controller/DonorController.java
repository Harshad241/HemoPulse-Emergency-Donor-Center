package com.hemopulse.donor.controller;

import com.hemopulse.donor.model.Donor;
import com.hemopulse.donor.repository.DonorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donors")
public class DonorController {

    private final DonorRepository donorRepository;

    public DonorController(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @GetMapping
    public ResponseEntity<List<Donor>> getAllDonors() {
        return ResponseEntity.ok(donorRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonorById(@PathVariable Long id) {
        return donorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Donor> createDonor(@RequestBody Donor donor) {
        Donor savedDonor = donorRepository.save(donor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDonor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donor> updateDonor(@PathVariable Long id, @RequestBody Donor donorDetails) {
        return donorRepository.findById(id)
                .map(existingDonor -> {
                    existingDonor.setFullName(donorDetails.getFullName());
                    existingDonor.setBloodGroup(donorDetails.getBloodGroup());
                    existingDonor.setPhoneNumber(donorDetails.getPhoneNumber());
                    existingDonor.setEmail(donorDetails.getEmail());
                    existingDonor.setCity(donorDetails.getCity());
                    existingDonor.setLastDonationDate(donorDetails.getLastDonationDate());
                    Donor updatedDonor = donorRepository.save(existingDonor);
                    return ResponseEntity.ok(updatedDonor);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Donor> partialUpdateDonor(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return donorRepository.findById(id)
                .map(existingDonor -> {
                    if (updates.containsKey("fullName") && updates.get("fullName") != null) {
                        existingDonor.setFullName((String) updates.get("fullName"));
                    }
                    if (updates.containsKey("bloodGroup") && updates.get("bloodGroup") != null) {
                        existingDonor.setBloodGroup((String) updates.get("bloodGroup"));
                    }
                    if (updates.containsKey("phoneNumber") && updates.get("phoneNumber") != null) {
                        existingDonor.setPhoneNumber((String) updates.get("phoneNumber"));
                    }
                    if (updates.containsKey("email") && updates.get("email") != null) {
                        existingDonor.setEmail((String) updates.get("email"));
                    }
                    if (updates.containsKey("city") && updates.get("city") != null) {
                        existingDonor.setCity((String) updates.get("city"));
                    }
                    if (updates.containsKey("lastDonationDate") && updates.get("lastDonationDate") != null) {
                        existingDonor.setLastDonationDate((String) updates.get("lastDonationDate"));
                    }

                    Donor updatedDonor = donorRepository.save(existingDonor);
                    return ResponseEntity.ok(updatedDonor);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonor(@PathVariable Long id) {
        if (!donorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        donorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
