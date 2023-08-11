package com.likelion.thinker.entity;

import com.likelion.thinker.dto.KeywordDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keywordId;

    private String name;

    public static Keyword toAdd(KeywordDto keywordDto) {
        return Keyword.builder()
                .name(keywordDto.getName())
                .build();
    }
}
