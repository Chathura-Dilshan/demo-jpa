package com.example.jpa.demojpa.converter;

import com.example.jpa.demojpa.dto.BookDto;
import com.example.jpa.demojpa.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {
    public BookDto entityToDto(Book book) {
        BookDto bookDto=new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setPrice(book.getPrice());
        bookDto.setTopics(book.getTopics());

        return bookDto;

    }

    public Book dtoToEntity(BookDto bookDto) {
        Book book=new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        book.setPrice(bookDto.getPrice());
        book.setTopics(bookDto.getTopics());
        return book;
    }
}
