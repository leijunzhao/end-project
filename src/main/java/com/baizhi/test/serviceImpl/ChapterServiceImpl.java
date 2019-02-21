package com.baizhi.test.serviceImpl;

import com.baizhi.test.entity.Chapter;
import com.baizhi.test.mapper.ChapterMapper;
import com.baizhi.test.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    ChapterMapper chapterMapper;

    public void addChapter(Chapter chapter) {
        chapterMapper.insert(chapter);
    }
}
