package com.koreait.cloneinstagram.dm;

import com.koreait.cloneinstagram.dm.model.DmMsgDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StompController {
    private final DmService service;
    private final SimpMessageSendingOperations msgSendingOperation;

    @MessageMapping("/enter")
    public void enter(DmMsgDomain message) {
        System.out.println("연결성공");
        message.setMsg("채팅방에 참여하였습니다.");
        msgSendingOperation.convertAndSend("/sub/room/" + message.getIdm(), message);
    }

    @MessageMapping("/msg")
    public void message(DmMsgDomain message) {
        System.out.println(message);
        System.out.println(message.getIdm());
        System.out.println(message.getIuser());
        System.out.println(message.getMsg());
        service.insDmMsg(message);
        msgSendingOperation.convertAndSend("/sub/room/" + message.getIdm(), message);
    }
}
