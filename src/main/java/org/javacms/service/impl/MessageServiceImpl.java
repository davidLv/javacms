package org.javacms.service.impl;

import org.javacms.dao.MessageDao;
import org.javacms.service.MessageServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("messageService")
public class MessageServiceImpl implements MessageServiceInterface {
    @Autowired
    private MessageDao messageDao;
    public Integer getMessageCountByUserId(Integer userId) {
        // TODO Auto-generated method stub
        return this.messageDao.getMessageCountByUserId(userId);
    }

}
