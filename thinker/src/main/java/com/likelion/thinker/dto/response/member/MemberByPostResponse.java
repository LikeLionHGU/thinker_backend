package com.likelion.thinker.dto.response.member;

import com.likelion.thinker.dto.MemberDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberByPostResponse {
    private Long memberId;

    private String name;

    private String email;

    private String nickname;

    public static MemberByPostResponse toMemberByPostResponse(MemberDto memberDto) {
        return MemberByPostResponse.builder()
                .memberId(memberDto.getMemberId())
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .nickname(memberDto.getNickname())
                .build();
    }
}
