package com.likelion.thinker.service;

import com.likelion.thinker.dto.KeywordDto;
import com.likelion.thinker.entity.Keyword;
import com.likelion.thinker.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        List<Keyword> keywordList = keywordRepository.findAll();
        List<Keyword> keywords = new ArrayList<>();

        while (keywords.size() < 3) {
            Random random = new Random();
            int randomIndex = random.nextInt(keywordList.size());
            Keyword randomItem = keywordList.get(randomIndex);

            if (!keywords.contains(randomItem)) {
                keywords.add(randomItem);
            }
        }

        List<KeywordDto> keywordDtoList = keywords.stream().map(KeywordDto::toResponse).collect(Collectors.toList());

        return keywordDtoList;
    }

    public static <T> List<T> getRandomElements(List<T> list, int count) {
        List<T> result = new ArrayList<>();
        Random rand = new Random();

        while (result.size() < count) {
            int randomIndex = rand.nextInt(list.size());
            T randomItem = list.get(randomIndex);

            if (!result.contains(randomItem)) {
                result.add(randomItem);
            }
        }

        return result;
    }
}
