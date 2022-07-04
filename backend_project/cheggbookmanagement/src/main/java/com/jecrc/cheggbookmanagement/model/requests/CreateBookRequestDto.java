package com.jecrc.cheggbookmanagement.model.requests;


import com.jecrc.cheggbookmanagement.model.entities.Author;
import com.jecrc.cheggbookmanagement.model.entities.Books;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRequestDto {

    @NotBlank
    String name;

    @Email
    String isbn;

    @NotBlank
    int cost;

    @NotBlank
    String authorName;

    @NotBlank
    @Email
    String authorEmail;

    public Books toBook(){
        Author author= Author.builder()
                .name(authorName)
                .email(authorEmail)
                .build();
        return Books.builder()
                .name(name)
                .isbn(isbn)
                .cost(cost)
                .author(author)
                .build();
    }
}
