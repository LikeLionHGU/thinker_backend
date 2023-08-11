package com.likelion.thinker.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@Builder
public class CommentRequest {
    private String content;
}
