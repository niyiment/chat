package com.niyiment.chat.repository;

import com.niyiment.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySender(String sender);

    List<Message> findTop50ByOrderByCreatedAtDesc();
}
