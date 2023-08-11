package com.likelion.thinker.response;

import com.likelion.thinker.dto.TodayKeywordDto;
import com.likelion.thinker.entity.TodayKeyword;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TodayKeywordResponse {
    private Long todayKeywordId;

    private LocalDateTime date;

    private String firstKeyword;

    private String secondKeyword;

    private String thirdKeyword;

    public static TodayKeywordResponse toResponse(TodayKeywordDto todayKeywordDto) {
        return TodayKeywordResponse.builder()
                .date(todayKeywordDto.getDate())
                .firstKeyword(todayKeywordDto.getFirstKeyword())
                .secondKeyword(todayKeywordDto.getSecondKeyword())
                .thirdKeyword(todayKeywordDto.getThirdKeyword())
                .build();
    }

    public static TodayKeywordResponse toResponse(TodayKeyword todayKeyword) {
        return TodayKeywordResponse.builder()
                .date(todayKeyword.getDate())
                .firstKeyword(todayKeyword.getFirstKeyword())
                .secondKeyword(todayKeyword.getSecondKeyword())
                .thirdKeyword(todayKeyword.getThirdKeyword())
                .todayKeywordId(todayKeyword.getTodayKeywordId())
                .build();
    }
}
