package com.pelin.companyservice;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Company updateCompany(Long id, Company updated) {
        Company existing = companyRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updated.getName());
            return companyRepository.save(existing);
        }
        return null;
    }
}