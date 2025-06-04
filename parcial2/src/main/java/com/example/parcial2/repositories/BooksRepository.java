package com.example.parcial2.repositories;

import com.example.parcial2.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BooksRepository extends JpaRepository<Book, UUID> {
    public Book findByIsbn(String isbn);
    public List<Book> findByGenre(String genre);
    public List<Book> findByAuthor(String author);
    public List<Book> findByLanguage(String language);
    public List<Book> findByPagesBetween(int start, int end);
}
