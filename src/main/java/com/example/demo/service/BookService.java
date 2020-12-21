package com.example.demo.service;

import com.example.demo.service.dto.AddBookRequest;
import com.example.demo.service.dto.BookResponse;
import com.example.demo.service.dto.UpdateBookRequest;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import java.util.List;

public interface BookService {
    Single<String> addBook(AddBookRequest addBookRequest);

    Completable updateBook(UpdateBookRequest updateBookRequest);

    Single<List<BookResponse>> getAllBooks(int limit, int page);

    Single<BookResponse> getBookDetail(String id);

    Completable deleteBook(String id);
}
