package com.koreait.cloneinstagram.dm;

import com.koreait.cloneinstagram.dm.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    int insDm(DmUserEntity entity);
    List<DmDomain> selDmList(DmDto dto);


    int insDmMsg(DmMsgDomain domain);
    List<DmMsgDomain> selDmMsgList(DmDto dto);
    Long findDm(DmDto dto);
}
