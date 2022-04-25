package com.emt.bookstore.service.impl;

import com.emt.bookstore.model.Author;
import com.emt.bookstore.repository.AuthorRepository;
import com.emt.bookstore.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll ();
    }
}
