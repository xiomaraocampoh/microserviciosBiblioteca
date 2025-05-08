package com.xiomara.bookservice;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Book> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}/decrease")
    public Book decreaseCopies(@PathVariable Long id) {
        Book book = repository.findById(id).orElseThrow();
        book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        return repository.save(book);
    }

}
