package com.jecrc.cheggbookmanagement.model.requests;


import com.jecrc.cheggbookmanagement.model.entities.Author;
import com.jecrc.cheggbookmanagement.model.entities.Books;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

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

    @Positive
    Integer cost;

    @Positive
    Integer rentCost;

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
                .rentCost(rentCost)
                .author(author)
                .build();
    }
}
