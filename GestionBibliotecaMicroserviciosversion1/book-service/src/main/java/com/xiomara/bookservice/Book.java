package com.xiomara.bookservice;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private int copiesAvailable;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
