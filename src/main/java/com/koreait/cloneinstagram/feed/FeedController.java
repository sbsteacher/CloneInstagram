package com.koreait.cloneinstagram.feed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feed")
public class FeedController {

    @GetMapping
    public String main() {
        return "feed/index";
    }


}
