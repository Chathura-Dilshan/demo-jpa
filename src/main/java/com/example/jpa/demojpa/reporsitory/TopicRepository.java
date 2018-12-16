package com.example.jpa.demojpa.reporsitory;

import com.example.jpa.demojpa.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Integer> {

}
