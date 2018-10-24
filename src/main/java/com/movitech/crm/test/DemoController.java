package com.movitech.crm.test;

import com.movitech.crm.websocket.config.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhming on 2018/10/24.
 * 测试
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private MyHandler MyHandler;

    @GetMapping("sendMessage")
    public void sendMessage(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        // webSocketSession
        WebSocketSession socketSession = MyHandler.users.get(userId);
        socketSession.sendMessage(new TextMessage("发送了文本消息给用户: " + socketSession.getId()));
    }

    @GetMapping("login/{userId}")
    public void login(@PathVariable(value = "userId") Integer userId, HttpServletRequest request) {
        request.getSession().setAttribute("userId", userId);
    }

}
