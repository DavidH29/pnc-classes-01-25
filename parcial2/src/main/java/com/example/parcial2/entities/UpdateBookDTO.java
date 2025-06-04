package com.example.parcial2.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UpdateBookDTO {
    @NotEmpty
    private String title;

    @NotEmpty
    private String language;
}
