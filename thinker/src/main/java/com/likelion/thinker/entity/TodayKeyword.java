package com.likelion.thinker.entity;

import com.likelion.thinker.dto.TodayKeywordDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class TodayKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todayKeywordId;

    private LocalDateTime date;

    private String firstKeyword;

    private String secondKeyword;

    private String thirdKeyword;

    public static TodayKeyword toAdd(TodayKeywordDto todayKeywordDto) {
        return TodayKeyword.builder()
                .date(todayKeywordDto.getDate())
                .firstKeyword(todayKeywordDto.getFirstKeyword())
                .secondKeyword(todayKeywordDto.getSecondKeyword())
                .thirdKeyword(todayKeywordDto.getThirdKeyword())
                .build();
    }
}
