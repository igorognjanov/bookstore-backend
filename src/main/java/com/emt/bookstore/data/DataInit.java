package com.emt.bookstore.data;

import com.emt.bookstore.enums.Category;
import com.emt.bookstore.model.Author;
import com.emt.bookstore.model.Book;
import com.emt.bookstore.model.Country;
import com.emt.bookstore.repository.AuthorRepository;
import com.emt.bookstore.repository.BookRepository;
import com.emt.bookstore.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInit {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInit(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init() {
        Country country1 = new Country ("Country1", "France");
        Country country2 = new Country ("Country2", "USA");

        countryRepository.save (country1);
        countryRepository.save (country2);

        Author author1 = new Author ("Author1", "AuthorSurname1", country1);
        Author author2 = new Author ("Author2", "AuthorSurname2", country2);
        Author author3 = new Author ("Author3", "AuthorSurname3", country1);

        authorRepository.save (author1);
        authorRepository.save (author2);
        authorRepository.save (author3);

        Book book1 = new Book ("Book1", Category.BIOGRAPHY, author1, 5);
        Book book2 = new Book ("Book2", Category.DRAMA, author2, 15);
        Book book3 = new Book ("Book3", Category.HISTORY, author3, 52);
        Book book4 = new Book ("Book4", Category.BIOGRAPHY, author2, 55);
        Book book5 = new Book ("Book5", Category.BIOGRAPHY, author1, 21);
        Book book6 = new Book ("Book6", Category.BIOGRAPHY, author3, 1);
        Book book7 = new Book ("Book7", Category.BIOGRAPHY, author1, 0);
        Book book8 = new Book ("Book8", Category.BIOGRAPHY, author2, 2121);

        bookRepository.save (book1);
        bookRepository.save (book2);
        bookRepository.save (book3);
        bookRepository.save (book4);
        bookRepository.save (book5);
        bookRepository.save (book6);
        bookRepository.save (book7);
        bookRepository.save (book8);
    }
}
