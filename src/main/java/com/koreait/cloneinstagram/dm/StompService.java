package com.koreait.cloneinstagram.dm;

import com.koreait.cloneinstagram.dm.model.DmMsgDomain;
import com.koreait.cloneinstagram.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StompService {
    private final DmMapper mapper;
    private final AuthenticationFacade auth;

    public int insDmMsg(DmMsgDomain domain) {
        //TODO : Security Session 사용할 수 있게 변경
        return mapper.insDmMsg(domain);
    }
}
