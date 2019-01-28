package com.synergy.recupro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synergy.recupro.exception.ResourceNotFoundException;
import com.synergy.recupro.model.Lead;
import com.synergy.recupro.repository.LeadRepository;

@RestController
public class LeadController {

    

    @Autowired
    private LeadRepository leadRepository;
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('RECRUITMENT_LEAD', 'ADMIN')")
    @GetMapping("/leads")
    public List<Lead> getLead() {
        return leadRepository.findAll();
    }
// Commented these line to test the Spring data rest Create lead instead of legacy call.
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
    @PostMapping("/leads")
    public Lead createAccount(@Valid @RequestBody Lead leads) {
        return leadRepository.save(leads);
    }
    @PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
    @PostMapping("/leads/{leadId}")
    public Lead updateAccount(@PathVariable Long leadId,
                                   @Valid @RequestBody Lead leadsRequest) {
        return leadRepository.findById(leadId)
                .map(leads -> {
                	//leads.setName(leadsRequest.getName());
                	//leads.setDescription(leadsRequest.getDescription());
                    return leadRepository.save(leads);
                }).orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + leadId, null, leadsRequest));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/leads/{leadId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long leadId) {
        return leadRepository.findById(leadId)
                .map(leads -> {
                	leadRepository.delete(leads);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + leadId, null, leadId));
    }
}
