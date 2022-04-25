package com.emt.bookstore.model.dto;

import com.emt.bookstore.enums.Category;
import lombok.Data;

@Data
public class BookDTO {

    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;

    public BookDTO() {}
}
