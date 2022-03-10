package com.koreait.cloneinstagram.dm;

import com.koreait.cloneinstagram.dm.model.DmDomain;
import com.koreait.cloneinstagram.dm.model.DmDto;
import com.koreait.cloneinstagram.dm.model.DmMsgDomain;
import com.koreait.cloneinstagram.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DmService {

    private final DmMapper mapper;
    private final AuthenticationFacade auth;

    public int insDmMsg(DmMsgDomain domain) {
        //TODO : Security Session 사용할 수 있게 변경
        return mapper.insDmMsg(domain);
    }

    public List<DmDomain> selDmList(DmDto dto) {
        dto.setFromiuser(auth.getLoginUserPk());
        return mapper.selDmList(dto);
    }

    //return value : idm
    public long findDm(DmDto dto) {
        Long idm = mapper.findDm(dto);
        return idm == null ? 0 : idm;
    }
}
