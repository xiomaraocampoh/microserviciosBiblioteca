package com.xiomara.loanservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceClient {

    private final RestTemplate restTemplate;

    public BookServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void decreaseBookCopies(Long bookId) {
        restTemplate.put("http://localhost:8081/books/" + bookId + "/decrease", null);
    }

}
