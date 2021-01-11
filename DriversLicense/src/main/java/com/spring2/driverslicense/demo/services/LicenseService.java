package com.spring2.driverslicense.demo.services;

import com.spring2.driverslicense.demo.models.License;
import com.spring2.driverslicense.demo.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository=licenseRepository;
    }

    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }

    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }
    public void deleteLicense(Long id) {
        licenseRepository.deleteById(id);
    }

    public License createLicense(License l) {
        l.setNumber(this.generateLicenseNumber());
        return licenseRepository.save(l);
    }

    public int generateLicenseNumber() {
        License l = licenseRepository.findTopByOrderByNumberDesc();
        if(l == null)
            return 1;
        int largestNumber = l.getNumber();

        largestNumber++;
        return (largestNumber);
    }






}