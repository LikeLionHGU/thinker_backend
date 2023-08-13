package com.likelion.thinker.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    private String memberId;

    private String name;

    private String email;
}
