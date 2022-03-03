package com.koreait.cloneinstagram.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
    private Long iuser;
    private String provider;
    private String email;
    private String pw;
    private String nm;
    private String cmt;
    private String mainimg;
    private String regdt;
}
