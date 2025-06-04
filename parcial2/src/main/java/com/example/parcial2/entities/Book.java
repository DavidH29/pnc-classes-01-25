package com.example.parcial2.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @Pattern(regexp = ".*[a-zA-Z].*")
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^(?:ISBN(?:-13)?:? )?(?<gs1>\\d{3})(?:(?<number>\\d{9})|(?=[\\d -]{14}$)[ -](?<registrationGroup>\\d{1,5})[ -](?<registrant>\\d{1,7})[ -](?<publication>\\d{1,6})[ -])(?<checkDigit>\\d)$")
    private String isbn;

    @Column(nullable = false)
    @Min(1900)
    @Max(2025)
    private Integer publicationYear;

    @Column(nullable = false)
    @Min(10)
    private Integer pages;

    @Column
    private String language;

    @Column(nullable = false)
    private String genre;
}
