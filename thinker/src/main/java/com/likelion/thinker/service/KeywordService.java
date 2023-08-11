package com.likelion.thinker.service;

import com.likelion.thinker.dto.KeywordDto;
import com.likelion.thinker.entity.Keyword;
import com.likelion.thinker.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KeywordService {
    private final KeywordRepository keywordRepository;

    @Transactional
    public Long addKeyword(KeywordDto keywordDto) {
        Keyword keyword = keywordRepository.save(Keyword.toAdd(keywordDto));

        return keyword.getKeywordId();
    }

    @Transactional
    public List<KeywordDto> getThreeKeyword() {
        List<Keyword> keywordList = keywordRepository.findRandomThreeKeyword();
        List<KeywordDto> keywordDtoList = keywordList.stream().map(KeywordDto::toResponse).collect(Collectors.toList());

        return keywordDtoList;
    }
}
