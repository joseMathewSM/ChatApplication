package com.jose.exercise2.mapper;

import com.jose.exercise2.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatMessageMapper {

    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getChatMessage();

    @Insert("INSERT INTO MESSAGES (messageid, username, messagetext) VALUES(#{messageid}, #{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insertChatMessage(ChatMessage cm);

}
