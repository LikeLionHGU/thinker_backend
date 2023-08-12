package com.likelion.thinker.dto;

import com.likelion.thinker.entity.Keyword;
import com.likelion.thinker.dto.request.KeywordRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class KeywordDto {

    private Long keywordId;

    private String name;

    public static KeywordDto toAdd(KeywordRequest keywordRequest) {
        return KeywordDto.builder()
                .name(keywordRequest.getName())
                .build();
    }

    public static KeywordDto toResponse(Keyword keyword) {
        return KeywordDto.builder()
                .name(keyword.getName())
                .keywordId(keyword.getKeywordId())
                .build();
    }
}
