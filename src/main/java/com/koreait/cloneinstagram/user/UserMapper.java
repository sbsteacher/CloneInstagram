package com.koreait.cloneinstagram.user;

import com.koreait.cloneinstagram.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserEntity entity);
    UserEntity findByEmail(String email);
}
