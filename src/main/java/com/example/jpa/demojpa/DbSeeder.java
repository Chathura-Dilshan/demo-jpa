package com.example.jpa.demojpa;

import com.example.jpa.demojpa.entity.Book;
import com.example.jpa.demojpa.entity.Topic;
import com.example.jpa.demojpa.reporsitory.BookRepository;
import com.example.jpa.demojpa.reporsitory.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@ConditionalOnProperty(name = "book.db.recreate",havingValue = "true")
public class  DbSeeder implements CommandLineRunner {
    private BookRepository bookRepository;
    private TopicRepository topicRepository;

    public DbSeeder(BookRepository bookRepository, TopicRepository topicRepository) {
        this.bookRepository = bookRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        this.bookRepository.deleteAll();
        this.topicRepository.deleteAll();

        Book book=new Book("Book1","author1",500.00);
        this.bookRepository.save(book);

        Book book1=new Book("Book2","author2",1500.00);
        this.bookRepository.save(book1);

        Topic topic=new Topic("Topic1","Description1",book);
        this.topicRepository.save(topic);

        Topic topic1=new Topic("Topic2","Description2",book1);
        this.topicRepository.save(topic1);


        System.out.println("db set ok");


    }
}
