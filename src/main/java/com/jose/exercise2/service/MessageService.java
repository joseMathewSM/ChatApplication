package com.jose.exercise2.service;

import com.jose.exercise2.mapper.ChatMessageMapper;
import com.jose.exercise2.model.ChatForm;
import com.jose.exercise2.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final ChatMessageMapper cmMapper;

    public MessageService(ChatMessageMapper cmMapper) {
        this.cmMapper = cmMapper;
    }

    public void addMessage(ChatForm cForm){
        ChatMessage cm = new ChatMessage();
        cm.setUsername(cForm.getUsername());
        cm.setMessageText(cForm.getMessageText());
        cmMapper.insertChatMessage(cm);
    }

    public List getMessage(){
        return cmMapper.getChatMessage();
    }

}
