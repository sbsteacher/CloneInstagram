package com.koreait.cloneinstagram.user;

import com.koreait.cloneinstagram.security.ProviderType;
import com.koreait.cloneinstagram.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public int signUp(UserEntity userEntity) {
        String hashedPw = passwordEncoder.encode(userEntity.getPw());
        userEntity.setPw(hashedPw);
        userEntity.setProvider(ProviderType.LOCAL.toString());
        return mapper.insUser(userEntity);
    }
}
