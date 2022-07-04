package com.jecrc.cheggbookmanagement.repository;

import com.jecrc.cheggbookmanagement.model.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {

    Optional<Books> findByIsbn(String isbn);
    Optional<List<Books>> findByName(String name);


}
