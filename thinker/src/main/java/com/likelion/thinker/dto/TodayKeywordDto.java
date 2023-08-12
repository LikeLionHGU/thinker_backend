package com.likelion.thinker.dto;

import com.likelion.thinker.entity.TodayKeyword;
import com.likelion.thinker.dto.request.TodayKeywordRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TodayKeywordDto {
    private Long todayKeywordId;

    private LocalDateTime date;

    private String firstKeyword;

    private String secondKeyword;

    private String thirdKeyword;

    public static TodayKeywordDto toAdd(TodayKeywordRequest todayKeywordRequest) {
        return TodayKeywordDto.builder()
                .date(todayKeywordRequest.getDate())
                .firstKeyword(todayKeywordRequest.getFirstKeyword())
                .secondKeyword(todayKeywordRequest.getSecondKeyword())
                .thirdKeyword(todayKeywordRequest.getThirdKeyword())
                .build();
    }

    public static TodayKeywordDto toResponse(TodayKeyword todayKeyword) {
        return TodayKeywordDto.builder()
                .date(todayKeyword.getDate())
                .firstKeyword(todayKeyword.getFirstKeyword())
                .secondKeyword(todayKeyword.getSecondKeyword())
                .thirdKeyword(todayKeyword.getThirdKeyword())
                .todayKeywordId(todayKeyword.getTodayKeywordId())
                .build();
    }
}
