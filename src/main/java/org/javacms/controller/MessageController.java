package org.javacms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.javacms.service.MessageServiceInterface;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
    @Autowired
    private MessageServiceInterface messageService;
    
    @ResponseBody
    @RequestMapping("/admin/message/getUnreadMsgCount")
    public String getUnreadMsgCount(HttpSession session) {
        JSONObject json = new JSONObject();
        Integer count = messageService.getMessageCountByUserId((Integer) session.getAttribute("userId"));
        //Map<String, Object> map = new HashMap<String, Object>();
        json.put("result", 200);
        json.put("count", count);
        return json.toString();
    }
}
