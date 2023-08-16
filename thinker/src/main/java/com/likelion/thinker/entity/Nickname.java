package com.likelion.thinker.entity;

import com.likelion.thinker.dto.NicknameDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Nickname {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nicknameId;

    private Long nicknameType;

    private String nickname;

    public static Nickname toNickname(NicknameDto nicknameDto) {
        return Nickname.builder()
                .nickname(nicknameDto.getNickname())
                .nicknameType(nicknameDto.getNicknameType())
                .build();
    }
}
