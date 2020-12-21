package com.example.demo.service.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.dto.AddBookRequest;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity> addBook(
            @RequestBody AddBookRequest addBookRequest
    ) {
        return bookService.addBook(addBookRequest).subscribeOn(Schedulers.io()).map(
                s -> ResponseEntity.created(URI.create("/api/books/" + s)).body(new Book()));
    }

    @GetMapping()
    public Single<ResponseEntity> getAllBooks(
            @RequestParam(value = "limit", defaultValue = "5") int limit,
            @RequestParam(value = "page", defaultValue = "0") int page) {
        return bookService.getAllBooks(limit, page).subscribeOn(Schedulers.io())
                .map(ResponseEntity::ok);
    }

}
