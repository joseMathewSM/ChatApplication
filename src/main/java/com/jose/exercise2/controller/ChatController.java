package com.jose.exercise2.controller;

import com.jose.exercise2.model.ChatForm;
import com.jose.exercise2.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService msgService;
    public ChatController(MessageService msgService){
        this.msgService = msgService;
    }

    @GetMapping
    public String getChat(ChatForm cForm, Model model){
        model.addAttribute("chatMessage", msgService.getMessage());
        return "chat";
    }

    @PostMapping
    public String postChat(ChatForm cForm, Model model, Authentication authentication){
        cForm.setUsername(authentication.getName());
        msgService.addMessage(cForm);
        cForm.setMessageText("");
        model.addAttribute("chatMessage", msgService.getMessage());
        return "chat";
    }

    @ModelAttribute("allOpt")
    public String[] allOpt(){
        return new String[] {"Say","Shout","Whisper"};
    }

}
