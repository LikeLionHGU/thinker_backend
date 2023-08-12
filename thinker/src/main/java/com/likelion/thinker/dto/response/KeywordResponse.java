package com.likelion.thinker.dto.response;

import com.likelion.thinker.dto.KeywordDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class KeywordResponse {

    private String name;

    private Long keywordId;

    public static KeywordResponse toResponse(KeywordDto keywordDto) {
        return KeywordResponse.builder()
                .keywordId(keywordDto.getKeywordId())
                .name(keywordDto.getName())
                .build();
    }
}
