package com.likelion.thinker.service;

import com.likelion.thinker.dto.TodayKeywordDto;
import com.likelion.thinker.entity.TodayKeyword;
import com.likelion.thinker.repository.TodayKeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodayKeywordService {
    private final TodayKeywordRepository todayKeywordRepository;

    @Transactional
    public Long addTodayKeyword(TodayKeywordDto todayKeywordDto) {
        TodayKeyword todayKeyword = todayKeywordRepository.save(TodayKeyword.toAdd(todayKeywordDto));

        return todayKeyword.getTodayKeywordId();
    }

    @Transactional
    public List<TodayKeywordDto> getTodayKeyword() {
        List<TodayKeyword> todayKeywordList = todayKeywordRepository.findAll();
        List<TodayKeywordDto> todayKeywordDtoList = todayKeywordList.stream().map(TodayKeywordDto::toResponse).collect(Collectors.toList());

        return todayKeywordDtoList;
    }
}
