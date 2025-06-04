package com.example.parcial2.services;

import com.example.parcial2.entities.Book;
import com.example.parcial2.entities.CreateBookDTO;
import com.example.parcial2.entities.UpdateBookDTO;
import com.example.parcial2.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BooksServices {

    @Autowired
    private BooksRepository booksRepository;

    public void addBook(CreateBookDTO book) {
        Book newBook = new Book();
        newBook.setAuthor(book.getAuthor());
        newBook.setTitle(book.getTitle());
        newBook.setIsbn(book.getIsbn());
        newBook.setPages(book.getPages());
        newBook.setGenre(book.getGenre());
        newBook.setLanguage(book.getLanguage());
        newBook.setPublicationYear(book.getPublicationYear());
        booksRepository.save(newBook);
    }

    public void updateBook(UpdateBookDTO book, UUID id) {
        Optional<Book> opBook = booksRepository.findById(id);
        if (opBook.isEmpty()) {
            throw new RuntimeException("Book not found");
        }
        Book bookToUpdate = opBook.get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setLanguage(book.getLanguage());
        booksRepository.save(bookToUpdate);
    }

    public void deleteBook(UUID bookId) {
        Optional<Book> opBook = booksRepository.findById(bookId);
        if (opBook.isEmpty()) {
            throw new RuntimeException("Book not found");
        }
        Book bookToDelete = opBook.get();
        booksRepository.delete(bookToDelete);
    }

    public Book getBookByIsbn(String isbn) {
        return booksRepository.findByIsbn(isbn);
    }

    public List<Book> getBooksByAuthor(String author) {
        return booksRepository.findByAuthor(author);
    }

    public List<Book> getBooksByGenre(String genre) {
        return booksRepository.findByGenre(genre);
    }

    public List<Book> getBooksByLanguage(String lang) {
        return booksRepository.findByLanguage(lang);
    }

    public List<Book> getBooksByPagesRanges(Integer start, Integer end) {
        return booksRepository.findByPagesBetween(start, end);
    }
}
