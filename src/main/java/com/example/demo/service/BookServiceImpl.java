package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.dto.AddBookRequest;
import com.example.demo.service.dto.BookResponse;
import com.example.demo.service.dto.UpdateBookRequest;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Single<String> addBook(AddBookRequest addBookRequest) {
        return saveBookToRepository(addBookRequest);
    }

    private Single<String> saveBookToRepository(AddBookRequest addBookRequest) {
        return Single.create(singleSuscriber -> {
            String addedBookId = bookRepository.save(toBook(addBookRequest)).getId();
            singleSuscriber.onSuccess(addedBookId);
        });
    }

    private Book toBook(AddBookRequest addBookRequest) {
        Book book = new Book();
        BeanUtils.copyProperties(addBookRequest, book);
        book.setId(UUID.randomUUID().toString());
        return book;
    }

    @Override
    public Completable updateBook(UpdateBookRequest updateBookRequest) {
        return updateBookToRepository(updateBookRequest);
    }

    private Completable updateBookToRepository(UpdateBookRequest updateBookRequest) {
        return Completable.create(completableSuscriber -> {
            Optional<Book> optionalBook = bookRepository.findById(updateBookRequest.getId());
            if (!optionalBook.isPresent()) {
                completableSuscriber.onError(new EntityNotFoundException());
            } else {
                Book book = optionalBook.get();
                book.setTitle(updateBookRequest.getTitle());
                bookRepository.save(book);
                completableSuscriber.onComplete();
            }
        });
    }

    @Override
    public Single<List<BookResponse>> getAllBooks(int limit, int page) {
        return findAllBooksInRepository(limit, page).map(this::toBookResponseList);
    }

    private Single<List<Book>> findAllBooksInRepository(int limit, int page) {
        return Single.create(singleSuscriber -> {
            List<Book> books = bookRepository.findAll(PageRequest.of(page, limit)).getContent();
            singleSuscriber.onSuccess(books);
        });
    }

    private List<BookResponse> toBookResponseList(List<Book> bookList) {
        return bookList.stream().map(this::toBookResponse).collect(Collectors.toList());
    }

    private BookResponse toBookResponse(Book book) {
        BookResponse bookResponse = new BookResponse();
        BeanUtils.copyProperties(book, bookResponse);
        return bookResponse;
    }

    @Override
    public Single<BookResponse> getBookDetail(String id) {
        return findBookDetailInRepository(id);
    }

    private Single<BookResponse> findBookDetailInRepository(String id) {
        return Single.create(singleSuscriber -> {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if (!optionalBook.isPresent()) {
                singleSuscriber.onError(new EntityNotFoundException());
            } else {
                BookResponse bookResponse = toBookResponse(optionalBook.get());
                singleSuscriber.onSuccess(bookResponse);
            }
        });
    }

    @Override
    public Completable deleteBook(String id) {
        return deleteBookInRepository(id);
    }

    private Completable deleteBookInRepository(String id) {
        return Completable.create(completableSuscriptor -> {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if (!optionalBook.isPresent()) {
                completableSuscriptor.onError(new EntityNotFoundException());
            } else {
                bookRepository.delete(optionalBook.get());
                completableSuscriptor.onComplete();
            }
        });
    }

}
