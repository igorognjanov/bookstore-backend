package com.emt.bookstore.web;

import com.emt.bookstore.model.Book;
import com.emt.bookstore.model.dto.BookDTO;
import com.emt.bookstore.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("https://lit-stream-23888.herokuapp.com")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll ();

    }

    @GetMapping("/pagination")
    public List<Book> findAllWithPagination(Pageable pageable) {
        return bookService.findAllWithPagination (pageable).getContent ();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return bookService.findById (id)
                .map (book -> ResponseEntity.ok().body (book))
                .orElseGet (() -> ResponseEntity.notFound ().build ());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDTO bookDTO) {
        return bookService.save (bookDTO)
                .map (book -> ResponseEntity.ok ().body (book))
                .orElseGet (() -> ResponseEntity.badRequest ().build ());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(
            @PathVariable Long id,
            @RequestBody BookDTO bookDTO){
        return bookService.edit (id, bookDTO)
                .map (book -> ResponseEntity.ok ().body (book))
                .orElseGet (() -> ResponseEntity.badRequest ().build ());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        bookService.deleteById (id);
        if (bookService.findById (id).isPresent ())
            return ResponseEntity.badRequest ().build ();
        return ResponseEntity.ok ().build ();
    }

    @PostMapping("/mark-as-taken/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id) {
        return bookService.markAsTaken (id)
                .map (book -> ResponseEntity.ok ().body (book))
                .orElseGet (() -> ResponseEntity.badRequest ().build ());
    }

}
