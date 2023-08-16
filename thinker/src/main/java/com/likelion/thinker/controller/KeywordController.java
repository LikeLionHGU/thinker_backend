package com.likelion.thinker.controller;

import com.likelion.thinker.dto.KeywordDto;
import com.likelion.thinker.dto.TodayKeywordDto;
import com.likelion.thinker.dto.request.KeywordRequest;
import com.likelion.thinker.dto.request.TodayKeywordRequest;
import com.likelion.thinker.dto.response.KeywordResponse;
import com.likelion.thinker.dto.response.TodayKeywordResponse;
import com.likelion.thinker.service.KeywordService;
import com.likelion.thinker.service.TodayKeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/keywords")
@CrossOrigin(origins = "*")
public class KeywordController {
    private final KeywordService keywordService;
    private final TodayKeywordService todayKeywordService;

    @PostMapping("/add")
    public ResponseEntity<Long> addKeyword(@RequestBody KeywordRequest keywordRequest) {
        KeywordDto keywordDto = KeywordDto.toAdd(keywordRequest);
        Long responseId = keywordService.addKeyword(keywordDto);

        return ResponseEntity.ok(responseId);
    }

    @GetMapping("/random")
    public ResponseEntity<List<KeywordResponse>> getThreeKeyword() {
        List<KeywordDto> keywordDtoList = keywordService.getThreeKeyword();
        List<KeywordResponse> keywordResponseList = keywordDtoList.stream().map(KeywordResponse::toResponse).collect(Collectors.toList());

        return ResponseEntity.ok(keywordResponseList);
    }

    @PostMapping("/today/add")
    public ResponseEntity<Long> addTodayKeyword(@RequestBody TodayKeywordRequest todayKeywordRequest) {
        TodayKeywordDto todayKeywordDto = TodayKeywordDto.toAdd(todayKeywordRequest);
        Long responseId = todayKeywordService.addTodayKeyword(todayKeywordDto);

        return ResponseEntity.ok(responseId);
    }

    @GetMapping
    public ResponseEntity<List<TodayKeywordResponse>> getTodayKeyword() {
        List<TodayKeywordDto> todayKeywordDtoList = todayKeywordService.getTodayKeyword();
        List<TodayKeywordResponse> todayKeywordResponseList = todayKeywordDtoList.stream().map(TodayKeywordResponse::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(todayKeywordResponseList);
    }
}
