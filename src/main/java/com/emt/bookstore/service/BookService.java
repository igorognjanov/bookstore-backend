package com.emt.bookstore.service;

import com.emt.bookstore.model.Book;
import com.emt.bookstore.model.dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Page<Book> findAllWithPagination(Pageable pageable);

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDTO bookDTO);

    Optional<Book> edit(Long id, BookDTO bookDTO);

    void deleteById(Long id);

    Optional<Book> markAsTaken(Long id);

}
