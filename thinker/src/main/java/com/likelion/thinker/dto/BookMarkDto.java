package com.likelion.thinker.dto;

import com.likelion.thinker.dto.request.BookMarkRequest;
import com.likelion.thinker.entity.BookMark;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookMarkDto {
    private String url;

    private String title;

    private Long userId;

    private MultipartFile file;

    private String fileUrl;

    public static BookMarkDto toBookMarkDto(BookMarkRequest bookMarkRequest, Long userId, MultipartFile file) {
        return BookMarkDto.builder()
                .url(bookMarkRequest.getUrl())
                .title(bookMarkRequest.getTitle())
                .userId(userId)
                .file(file)
                .build();
    }

    public static BookMarkDto toBookMarkDto(String url, Long userId) {
        return BookMarkDto.builder()
                .userId(userId)
                .url(url)
                .build();
    }

    public static BookMarkDto toResponse(BookMark bookMark) {
        return BookMarkDto.builder()
                .url(bookMark.getUrl())
                .title(bookMark.getTitle())
                .build();
    }
}
