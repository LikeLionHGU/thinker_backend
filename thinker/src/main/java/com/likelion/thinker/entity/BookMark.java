package com.likelion.thinker.entity;

import com.likelion.thinker.dto.BookMarkDto;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.awt.print.Book;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookMark {
    @Id
    private String url;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public static BookMark toBookMark(BookMarkDto bookMarkDto, Member member) {
        return BookMark.builder()
                .url(bookMarkDto.getUrl())
                .title(bookMarkDto.getTitle())
                .member(member)
                .build();
    }
}
