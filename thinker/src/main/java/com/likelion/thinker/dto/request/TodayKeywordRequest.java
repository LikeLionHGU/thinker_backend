package com.likelion.thinker.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodayKeywordRequest {
    private LocalDateTime date;

    private String firstKeyword;

    private String secondKeyword;

    private String thirdKeyword;
}
