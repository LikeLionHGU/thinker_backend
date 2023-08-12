package com.likelion.thinker.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TodayKeywordRequest {
    private LocalDateTime date;

    private String firstKeyword;

    private String secondKeyword;

    private String thirdKeyword;
}
