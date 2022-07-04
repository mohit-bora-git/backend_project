package com.jecrc.cheggbookmanagement.service;

import com.jecrc.cheggbookmanagement.model.entities.Author;
import com.jecrc.cheggbookmanagement.model.entities.Books;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author saveOrUpdateBook(Author author);

    Optional<Author> findByEmail(String email);

    List<Books> getBookList(Integer id);

}
