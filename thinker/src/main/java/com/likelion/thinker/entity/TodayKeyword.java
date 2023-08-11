package com.likelion.thinker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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

    private String date;

    private String firstKeyword;

    private String secondKeyword;

    private String thirdKeyword;
}
