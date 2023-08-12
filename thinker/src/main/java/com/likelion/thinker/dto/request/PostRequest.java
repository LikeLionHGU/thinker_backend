package com.likelion.thinker.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PostRequest {
    private String title;

    private String content;
}
