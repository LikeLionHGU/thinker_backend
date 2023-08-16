package com.likelion.thinker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NicknameDto {
    private String nickname;

    private Long nicknameType;
}
