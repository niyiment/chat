package com.niyiment.chat.service;


import com.niyiment.chat.model.Message;
import com.niyiment.chat.model.MessageType;
import com.niyiment.chat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public Message save(Message message) {
        if (message.getType() == MessageType.JOIN) {
            message.setContent(message.getSender() + " joined!");
        } else if (message.getType() == MessageType.LEAVE) {
            message.setContent(message.getSender() + " left!");
        }

        return messageRepository.save(message);
    }

    public List<Message> getRecentMessages() {
        List<Message> messages = messageRepository.findTop50ByOrderByCreatedAtDesc();
        Collections.reverse(messages);

        return messages;
    }
}
