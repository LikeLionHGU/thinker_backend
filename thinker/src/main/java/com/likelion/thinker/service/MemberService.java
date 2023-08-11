package com.likelion.thinker.service;

import com.likelion.thinker.dto.MemberDto;
import com.likelion.thinker.entity.Member;
import com.likelion.thinker.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long addUser(MemberDto memberDto) {
        Member member = memberRepository.save(Member.toAdd(memberDto));

        return member.getMemberId();
    }

    @Transactional
    public MemberDto getUser(Long userId) {
        Member member = memberRepository.getById(userId);
        MemberDto memberDto = MemberDto.toMemberResponse(member);

        return memberDto;
    }
}
