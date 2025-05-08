package com.xiomara.loanservice;

import com.xiomara.loanservice.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
