package com.likelion.thinker.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookMarkDeleteRequest {
    private String url;
}
