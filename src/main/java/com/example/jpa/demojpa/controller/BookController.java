package com.example.jpa.demojpa.controller;

import com.example.jpa.demojpa.dto.BookDto;
import com.example.jpa.demojpa.entity.Book;
import com.example.jpa.demojpa.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //get all books
    @GetMapping("/all")
    public List<BookDto> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public  BookDto getBook(@PathVariable int id) throws ValidationException {
        return bookService.getBook(id);
    }

    @PostMapping
    public void saveBook(@RequestBody BookDto bookDto) throws ValidationException {
        bookService.saveBook(bookDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable int id) throws ValidationException {
        bookService.deleteBook(id);
    }
}
