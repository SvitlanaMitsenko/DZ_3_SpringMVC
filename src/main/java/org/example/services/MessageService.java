package org.example.services;

import org.example.dao.MessageDAO;
import org.example.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageDAO messageDAO;

    public List<Message> getMessageList() {
        return messageDAO.getMessageList();
    }

    public void createMessage(Message message) {
        messageDAO.addMessage(message);
    }
}
