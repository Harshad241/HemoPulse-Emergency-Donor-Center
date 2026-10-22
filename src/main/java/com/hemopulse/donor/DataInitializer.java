package com.hemopulse.donor;

import com.hemopulse.donor.model.Donor;
import com.hemopulse.donor.model.EmergencyRequest;
import com.hemopulse.donor.repository.DonorRepository;
import com.hemopulse.donor.repository.EmergencyRequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DonorRepository donorRepository;
    private final EmergencyRequestRepository emergencyRequestRepository;

    public DataInitializer(DonorRepository donorRepository, EmergencyRequestRepository emergencyRequestRepository) {
        this.donorRepository = donorRepository;
        this.emergencyRequestRepository = emergencyRequestRepository;
    }

    @Override
    public void run(String... args) {
        // 1. Seed Donors if empty
        if (donorRepository.count() == 0) {
            List<Donor> seedDonors = Arrays.asList(
                new Donor(null, "Rahul Sharma", "O+", "9876543210", "rahul.sharma@example.com", "Mumbai", "15 Aug 2026", 21, true, 4, 4.8),
                new Donor(null, "Priya Patel", "A+", "9823456781", "priya.patel@example.com", "Pune", "02 Jul 2026", 24, true, 6, 4.9),
                new Donor(null, "Amit Deshmukh", "B+", "9819012345", "amit.deshmukh@example.com", "Thane", "20 Sep 2026", 28, false, 3, 4.5),
                new Donor(null, "Sneha Kulkarni", "O-", "9765432109", "sneha.kulkarni@example.com", "Mumbai", "10 Jun 2026", 26, true, 8, 5.0),
                new Donor(null, "Vikram Rathore", "AB+", "9890123456", "vikram.r@example.com", "Navi Mumbai", "25 May 2026", 30, true, 5, 4.7),
                new Donor(null, "Ananya Iyer", "A-", "9834567890", "ananya.iyer@example.com", "Pune", "18 Sep 2026", 22, false, 2, 4.6),
                new Donor(null, "Rohan Varma", "B-", "9821987654", "rohan.varma@example.com", "Thane", "04 Apr 2026", 25, true, 7, 4.9),
                new Donor(null, "Meera Nair", "AB-", "9811223344", "meera.nair@example.com", "Mumbai", "12 Mar 2026", 27, true, 3, 4.7),
                new Donor(null, "Karan Mehta", "O+", "9845012345", "karan.mehta@example.com", "Pune", "11 Sep 2026", 29, false, 5, 4.6),
                new Donor(null, "Pooja Joshi", "A+", "9730123456", "pooja.j@example.com", "Navi Mumbai", "29 Jun 2026", 23, true, 4, 4.8),
                new Donor(null, "Devendra Patil", "B+", "9898765432", "devendra.p@example.com", "Mumbai", "01 May 2026", 32, true, 11, 4.9),
                new Donor(null, "Tanvi Sawant", "O-", "9819922334", "tanvi.s@example.com", "Navi Mumbai", "14 Sep 2026", 22, false, 2, 4.4)
            );

            donorRepository.saveAll(seedDonors);
            System.out.println("HemoPulse Database: " + seedDonors.size() + " donors pre-populated successfully.");
        }

        // 2. Seed Emergency Hospital Requirements if empty
        if (emergencyRequestRepository.count() == 0) {
            List<EmergencyRequest> seedRequests = Arrays.asList(
                new EmergencyRequest(null, "O-", "City Hospital", "CRITICAL", "3 Units", "Trauma Care", "10 mins ago"),
                new EmergencyRequest(null, "B-", "Sunrise Hospital", "URGENT", "2 Units", "Emergency ICU", "25 mins ago"),
                new EmergencyRequest(null, "AB+", "Apex Medical Center", "HIGH PRIORITY", "4 Units", "Surgical Ward", "40 mins ago"),
                new EmergencyRequest(null, "A-", "Metro Health Care", "URGENT", "2 Units", "Pediatric Emergency", "1 hour ago")
            );

            emergencyRequestRepository.saveAll(seedRequests);
            System.out.println("HemoPulse Database: " + seedRequests.size() + " emergency requests pre-populated successfully.");
        }
    }
}
