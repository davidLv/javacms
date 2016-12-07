package org.javacms.dao.impl;

import org.javacms.dao.MessageDao;
import org.javacms.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("messageDao")
public class MessageDaoImpl implements MessageDao {
    @Autowired
    private MessageMapper messageMapper;
    public Integer getMessageCountByUserId(Integer userId) {
        return messageMapper.getMessageCountByUserId(userId);
    }

}
