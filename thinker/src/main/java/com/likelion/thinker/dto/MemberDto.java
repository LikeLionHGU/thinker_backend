package com.likelion.thinker.dto;

import com.likelion.thinker.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDto {
    private Long memberId;

    private String name;

    private String email;

    public static MemberDto toResponse(Member member) {
        return MemberDto.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }
}
