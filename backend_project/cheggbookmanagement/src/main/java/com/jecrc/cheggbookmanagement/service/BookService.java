package com.jecrc.cheggbookmanagement.service;

import com.jecrc.cheggbookmanagement.model.entities.Books;
import com.jecrc.cheggbookmanagement.model.requests.CreateBookRequestDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public Books createBook(CreateBookRequestDto createBookRequestDto);
    public List<Books> getAllBook();
    public Optional<List<Books>> getBookByName(String name);
}
