package com.likelion.thinker.service;

import com.likelion.thinker.dto.MemberDto;
import com.likelion.thinker.entity.Member;
import com.likelion.thinker.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long addUser(MemberDto memberDto) {
        Member tempMember = memberRepository.findByMemberId(memberDto.getMemberId());

        if(tempMember == null) {
            Member member = memberRepository.save(Member.toAdd(memberDto));

            return member.getMemberId();
        } else {
            return null;
        }
    }

    @Transactional
    public MemberDto getUser(Long userId) {
        Member member = memberRepository.findByMemberId(userId);
        MemberDto memberDto = MemberDto.toResponse(member);

        return memberDto;
    }
}
