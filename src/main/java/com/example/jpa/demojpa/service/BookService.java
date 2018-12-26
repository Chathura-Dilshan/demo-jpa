package com.example.jpa.demojpa.service;

import com.example.jpa.demojpa.converter.BookConverter;
import com.example.jpa.demojpa.dto.BookDto;
import com.example.jpa.demojpa.entity.Book;
import com.example.jpa.demojpa.reporsitory.BookRepository;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;
    private BookConverter bookConverter;

    public BookService(BookRepository bookRepository, BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookConverter::entityToDto)
                .collect(Collectors.toList());
    }

    public BookDto getBook(int id) throws ValidationException {
        Book book=bookRepository.findById(id).orElse(null);
        if (book == null) {
            throw new ValidationException("Can not find id");
        }
        return bookConverter.entityToDto(book);
    }

    public void saveBook(BookDto bookDto) throws ValidationException {
        Book book=bookConverter.dtoToEntity(bookDto);
        if (bookDto.getId() == 0) {
            bookRepository.save(book);
        }else {
            BookDto bookDtoResult=getBook(bookDto.getId());
            bookRepository.save(book);
        }
    }

    public void deleteBook(int id) throws ValidationException {
        if (id == 0) {
            throw new ValidationException("Can not find id");
        }else {
            bookRepository.deleteById(id);
        }
    }
}
