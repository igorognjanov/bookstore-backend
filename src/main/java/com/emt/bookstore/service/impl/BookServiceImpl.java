package com.emt.bookstore.service.impl;

import com.emt.bookstore.model.Book;
import com.emt.bookstore.model.dto.BookDTO;
import com.emt.bookstore.repository.AuthorRepository;
import com.emt.bookstore.repository.BookRepository;
import com.emt.bookstore.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll ();
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return bookRepository.findAll (pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById (id);
    }

    @Override
    public Optional<Book> save(BookDTO bookDTO) {
        Book book = new Book (
                bookDTO.getName (),
                bookDTO.getCategory (),
                authorRepository.findById (bookDTO.getAuthor ())
                        .orElseThrow (() -> new RuntimeException ("Author with id=["+ bookDTO.getAuthor () + " not found.")),
                bookDTO.getAvailableCopies ());
        return Optional.of (bookRepository.save (book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById (id)
                .orElseThrow (() -> new RuntimeException ("Book with id = [" + id + "] not found"));
        book.setName (bookDTO.getName ());
        book.setAuthor (authorRepository.getById (bookDTO.getAuthor ()));
        book.setCategory (bookDTO.getCategory ());
        book.setAvailableCopies (bookDTO.getAvailableCopies ());
        return Optional.of (bookRepository.save (book));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById (id);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = bookRepository.findById (id)
                .orElseThrow (() -> new RuntimeException ("Book with id = [" + id + "] not found"));
        book.setAvailableCopies (book.getAvailableCopies () - 1);
        return Optional.of (bookRepository.save (book));
    }
}
