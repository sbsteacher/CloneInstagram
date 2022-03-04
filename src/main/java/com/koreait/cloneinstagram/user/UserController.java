package com.koreait.cloneinstagram.user;

import com.koreait.cloneinstagram.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping("/signin")
    public void signIn(UserEntity userEntity) {}

    @GetMapping("/signup")
    public void singUp(UserEntity userEntity) {}

    @PostMapping("/signup")
    public String singUpProc(UserEntity userEntity) {
        int result = service.signUp(userEntity);
        return "redirect:/user/signin";
    }
}
