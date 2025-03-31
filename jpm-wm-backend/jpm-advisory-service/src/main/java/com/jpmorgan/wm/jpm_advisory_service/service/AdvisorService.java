package com.jpmorgan.wm.jpm_advisory_service.service;

import com.jpmorgan.wm.jpm_advisory_service.exception.AdvisorNotFoundException;
import com.jpmorgan.wm.jpm_advisory_service.exception.DuplicateEmailException;
import com.jpmorgan.wm.jpm_advisory_service.model.Advisor;
import com.jpmorgan.wm.jpm_advisory_service.model.AdvisorStatus;
import com.jpmorgan.wm.jpm_advisory_service.repository.AdvisorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvisorService {
    private final AdvisorRepository advisorRepository;

    public AdvisorService(AdvisorRepository advisorRepository) {
        this.advisorRepository = advisorRepository;
    }

    public List<Advisor> getAllAdvisors() {
        return advisorRepository.findAll();
    }

    public Advisor getAdvisorById(Long id) {
        return advisorRepository.findById(id)
                .orElseThrow(() -> new AdvisorNotFoundException(id));
    }

    public List<Advisor> getAdvisorsByStatus(AdvisorStatus status) {
        return advisorRepository.findByStatus(status);
    }

    @Transactional
    public Advisor createAdvisor(Advisor advisor) {
        if (advisorRepository.existsByEmail(advisor.getEmail())) {
            throw new DuplicateEmailException(advisor.getEmail());
        }
        return advisorRepository.save(advisor);
    }

    @Transactional
    public Advisor updateAdvisor(Long id, Advisor advisorDetails) {
        Advisor advisor = getAdvisorById(id);

        if (!advisor.getEmail().equals(advisorDetails.getEmail()) &&
                advisorRepository.existsByEmail(advisorDetails.getEmail())) {
            throw new DuplicateEmailException(advisorDetails.getEmail());
        }

        advisor.setFirstName(advisorDetails.getFirstName());
        advisor.setLastName(advisorDetails.getLastName());
        advisor.setEmail(advisorDetails.getEmail());
        advisor.setPhone(advisorDetails.getPhone());
        advisor.setSpecializations(advisorDetails.getSpecializations());
        advisor.setStatus(advisorDetails.getStatus());

        return advisorRepository.save(advisor);
    }

    @Transactional
    public boolean deleteAdvisor(Long id) {
        if (!advisorRepository.existsById(id)) {
            throw new AdvisorNotFoundException(id);
        }
        advisorRepository.deleteById(id);
        return true;
    }
}