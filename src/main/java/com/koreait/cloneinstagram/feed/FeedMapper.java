package com.koreait.cloneinstagram.feed;

import com.koreait.cloneinstagram.feed.model.FeedDTO;
import com.koreait.cloneinstagram.feed.model.FeedDomain;
import com.koreait.cloneinstagram.feed.model.FeedEntity;
import com.koreait.cloneinstagram.feed.model.FeedImgEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedEntity entity);
    List<FeedDomain> selFeedList(FeedDTO dto);

    int insFeedImg(FeedImgEntity entity);
}
