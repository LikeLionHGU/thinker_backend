package com.likelion.thinker.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    private Long memberId;

    private String name;

    private String email;
}
