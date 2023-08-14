package com.likelion.thinker.service;

import com.likelion.thinker.dto.BookMarkDto;
import com.likelion.thinker.entity.BookMark;
import com.likelion.thinker.entity.Member;
import com.likelion.thinker.repository.BookMarkRepository;
import com.likelion.thinker.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookMarkService {
    private final MemberRepository memberRepository;
    private final BookMarkRepository bookMarkRepository;

    @Transactional
    public String addBookMark(BookMarkDto bookMarkDto) {
        Member member = memberRepository.findByMemberId(bookMarkDto.getUserId());
        BookMark bookMark = bookMarkRepository.save(BookMark.toBookMark(bookMarkDto, member));

        String responseId = bookMark.getUrl();

        return responseId;
    }

    @Transactional
    public String deleteBookMak(BookMarkDto bookMarkDto) {
        Member member = memberRepository.findByMemberId(bookMarkDto.getUserId());
        bookMarkRepository.delete(BookMark.toBookMark(bookMarkDto, member));

        return bookMarkDto.getUrl();
    }
}
