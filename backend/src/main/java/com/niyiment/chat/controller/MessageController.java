package com.niyiment.chat.controller;


import com.niyiment.chat.model.Message;
import com.niyiment.chat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Message>> getRecentMessages() {
        return ResponseEntity.ok(messageService.getRecentMessages());
    }
}
