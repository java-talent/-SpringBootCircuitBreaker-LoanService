package com.javatalent.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatalent.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{
	List<Loan> findByType(String type);
}
