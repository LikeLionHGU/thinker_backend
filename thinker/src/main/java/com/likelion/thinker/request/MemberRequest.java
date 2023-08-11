package com.likelion.thinker.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberRequest {
    private String name;

    private String email;
}
