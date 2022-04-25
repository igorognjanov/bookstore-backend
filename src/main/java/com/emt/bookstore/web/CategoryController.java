package com.emt.bookstore.web;

import com.emt.bookstore.enums.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("https://bookstore-f.herokuapp.com")
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping
    public List<Category> findAll() {
        return List.of (Category.values ());
    }

}
