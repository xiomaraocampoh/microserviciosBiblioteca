package com.xiomara.loanservice;

import com.xiomara.loanservice.Loan;
import com.xiomara.loanservice.LoanRepository;
import com.xiomara.loanservice.BookServiceClient;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanRepository repository;
    private final BookServiceClient bookService;

    public LoanController(LoanRepository repository, BookServiceClient bookService) {
        this.repository = repository;
        this.bookService = bookService;
    }

    @GetMapping
    public List<Loan> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Loan create(@RequestBody Loan loan) {
        loan.setDateLoaned(LocalDate.now());
        loan.setReturnDate(LocalDate.now().plusDays(14));

        bookService.decreaseBookCopies(loan.getBookId());

        return repository.save(loan);
    }
}
