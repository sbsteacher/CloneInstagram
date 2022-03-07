package com.koreait.cloneinstagram.feed;

import com.koreait.cloneinstagram.ResultVo;
import com.koreait.cloneinstagram.feed.model.FeedDTO;
import com.koreait.cloneinstagram.feed.model.FeedDomain;
import com.koreait.cloneinstagram.feed.model.FeedEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedController {

    private final FeedService service;

    @GetMapping
    public String main() {
        return "feed/index";
    }

    @ResponseBody
    @PostMapping("/reg")
    public ResultVo reg(MultipartFile[] imgs, FeedEntity entity) {
        return new ResultVo(service.reg(imgs, entity));
    }

    @ResponseBody
    @GetMapping("/list")
    public List<FeedDomain> selFeedList(FeedDTO dto) {
        return service.selFeedList(dto);
    }
}
