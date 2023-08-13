package com.likelion.thinker.dto.response.member;

import com.likelion.thinker.dto.MemberDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberByPostResponse {
    private String memberId;

    private String name;

    private String email;

    public static MemberByPostResponse toMemberByPostResponse(MemberDto memberDto) {
        return MemberByPostResponse.builder()
                .memberId(memberDto.getMemberId())
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .build();
    }
}
