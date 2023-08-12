package com.likelion.thinker.dto.request;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    private String content;
}
