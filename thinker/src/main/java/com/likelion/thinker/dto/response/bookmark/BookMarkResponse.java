package com.likelion.thinker.dto.response.bookmark;

import com.likelion.thinker.dto.BookMarkDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookMarkResponse {
    private String url;

    private String title;

    public static BookMarkResponse toResponse(BookMarkDto bookMarkDto) {
        return BookMarkResponse.builder()
                .url(bookMarkDto.getUrl())
                .title(bookMarkDto.getTitle())
                .build();
    }
}
