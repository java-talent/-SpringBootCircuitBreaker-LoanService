package com.javatalent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatalent.entity.Loan;
import com.javatalent.service.LoanService;

@RestController
@RequestMapping("api")
public class LoanController {
	@Autowired
	private LoanService loanService;
	
	@GetMapping("/loans")
	public ResponseEntity<List<Loan>> getLoansByType(@RequestParam ("type") String type){
		return ResponseEntity.ok().body(loanService.getAllLoansByType(type.toUpperCase()));
	}
}
