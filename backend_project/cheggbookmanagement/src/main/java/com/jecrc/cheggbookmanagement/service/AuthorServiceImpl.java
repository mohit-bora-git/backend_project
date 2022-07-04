package com.jecrc.cheggbookmanagement.service;

import com.jecrc.cheggbookmanagement.model.entities.Author;
import com.jecrc.cheggbookmanagement.model.entities.Books;
import com.jecrc.cheggbookmanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author saveOrUpdateBook(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Optional<Author> findByEmail(String email) {
        return authorRepository.findByEmail(email);
    }

    @Override
    public List<Books> getBookList(Integer id) {
        Optional<Author> author=authorRepository.findById(id);
        if(author.isEmpty()){
            throw new RuntimeException();
        }
        return author.get().getBooksList();
    }
}
