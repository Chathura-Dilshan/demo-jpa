package com.example.jpa.demojpa.reporsitory;

import com.example.jpa.demojpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
