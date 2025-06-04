package com.example.parcial2.controllers;

import com.example.parcial2.entities.Book;
import com.example.parcial2.entities.CreateBookDTO;
import com.example.parcial2.entities.UpdateBookDTO;
import com.example.parcial2.services.BooksServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@RestController
@RequestMapping(path = "/books")
public class BooksController {

    private final Pattern UUID_REGEX =
            Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
    private final Pattern ISBN_REGEX =
            Pattern.compile("^(?:ISBN(?:-13)?:? )?(?<gs1>\\d{3})(?:(?<number>\\d{9})|(?=[\\d -]{14}$)[ -](?<registrationGroup>\\d{1,5})[ -](?<registrant>\\d{1,7})[ -](?<publication>\\d{1,6})[ -])(?<checkDigit>\\d)$");

    @Autowired
    private BooksServices booksServices;

    @GetMapping
    public ResponseEntity<List<Book>> getBooksByFilters(@RequestParam(required = false) String author,
                                                        @RequestParam(required = false) String language,
                                                        @RequestParam(required = false) String genre,
                                                        @RequestParam(required = false) String minPages,
                                                        @RequestParam(required = false) String maxPages) {
        if (author != null) {
            return ResponseEntity.ok(booksServices.getBooksByAuthor(author));
        }
        else if (language != null) {
            return ResponseEntity.ok(booksServices.getBooksByLanguage(language));
        }
        else if (genre != null) {
            return ResponseEntity.ok(booksServices.getBooksByGenre(genre));
        }
        else if (minPages != null && maxPages != null) {
            return ResponseEntity.ok(booksServices.getBooksByPagesRanges(Integer.valueOf(minPages), Integer.valueOf(maxPages)));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        if (!ISBN_REGEX.matcher(isbn).matches()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(booksServices.getBookByIsbn(isbn));
    }


    @PostMapping
    public ResponseEntity<Void> addBook(@RequestBody @Valid CreateBookDTO book) {
        booksServices.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Void> updateBook(@RequestBody @Valid UpdateBookDTO book, @PathVariable String id) {
        if (!UUID_REGEX.matcher(id).matches()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        booksServices.updateBook(book, UUID.fromString(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        if (!UUID_REGEX.matcher(id).matches()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        booksServices.deleteBook(UUID.fromString(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
