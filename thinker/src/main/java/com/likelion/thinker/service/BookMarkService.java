package com.likelion.thinker.service;

import com.likelion.thinker.dto.BookMarkDto;
import com.likelion.thinker.entity.BookMark;
import com.likelion.thinker.entity.Member;
import com.likelion.thinker.repository.BookMarkRepository;
import com.likelion.thinker.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookMarkService {
    private final MemberRepository memberRepository;
    private final BookMarkRepository bookMarkRepository;

    @Value("${cloud.accessKey}")
    private String accessKey;

    @Value("${cloud.secretKey}")
    private String secretKey;

    @Value("{cloud.bucketName}")
    private String bucketName;

    @Transactional
    public String addBookMark(BookMarkDto bookMarkDto) {
        Member member = memberRepository.findByMemberId(bookMarkDto.getUserId());
        BookMark tempBookMark = bookMarkRepository.findByBookMarkIdAndMemberId(member.getMemberId(), bookMarkDto.getUrl());

        if(tempBookMark == null) {
            BookMark bookMark = bookMarkRepository.save(BookMark.toBookMark(bookMarkDto, member));
            String responseId = bookMark.getUrl();

            return responseId;
        } else {
            return null;
        }
    }

    @Transactional
    public String deleteBookMak(BookMarkDto bookMarkDto) {
        Member member = memberRepository.findByMemberId(bookMarkDto.getUserId());
        BookMark bookMark = bookMarkRepository.findByBookMarkIdAndMemberId(member.getMemberId(), bookMarkDto.getUrl());

        if(bookMark == null) {
            return null;
        } else {
            bookMarkRepository.delete(BookMark.toBookMark(bookMarkDto, member));

            return bookMarkDto.getUrl();
        }
    }
}
