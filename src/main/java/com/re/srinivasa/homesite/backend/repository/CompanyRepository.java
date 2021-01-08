package com.re.srinivasa.homesite.backend.repository;

import com.re.srinivasa.homesite.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
