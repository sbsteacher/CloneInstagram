package com.koreait.cloneinstagram.dm;

import com.koreait.cloneinstagram.dm.model.DmDomain;
import com.koreait.cloneinstagram.dm.model.DmDto;
import com.koreait.cloneinstagram.dm.model.DmMsgDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dm")
public class DmController {

    private final DmService service;

    @GetMapping
    public String dm() {
        return "dm/index";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<DmDomain> selDmList(DmDto dto) {
        return service.selDmList(dto);
    }


}
