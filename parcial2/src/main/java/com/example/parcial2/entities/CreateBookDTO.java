package com.example.parcial2.entities;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
public class CreateBookDTO {

    @NotEmpty
    @Pattern(regexp = ".*[a-zA-Z].*")
    private String title;

    @NotEmpty
    private String author;

    @NotEmpty
    @Pattern(regexp = "^(?:ISBN(?:-13)?:? )?(?<gs1>\\d{3})(?:(?<number>\\d{9})|(?=[\\d -]{14}$)[ -](?<registrationGroup>\\d{1,5})[ -](?<registrant>\\d{1,7})[ -](?<publication>\\d{1,6})[ -])(?<checkDigit>\\d)$")
    private String isbn;

    @Min(1900)
    @Max(2025)
    @NotNull
    private Integer publicationYear;

    @NotNull
    @Min(10)
    private Integer pages;

    @NotEmpty
    private String language;

    @NotEmpty
    private String genre;
}
