package com.likelion.thinker.service;

import com.likelion.thinker.dto.MemberDto;
import com.likelion.thinker.entity.Member;
import com.likelion.thinker.entity.Nickname;
import com.likelion.thinker.repository.MemberRepository;
import com.likelion.thinker.repository.NicknameRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final NicknameRepository nicknameRepository;
    private final Long type1 = Long.valueOf(1);
    private final Long type2 = Long.valueOf(2);
    private final Long type3 = Long.valueOf(3);

    @Transactional
    public Long addUser(MemberDto memberDto) {
        Member tempMember = memberRepository.findByMemberId(memberDto.getMemberId());
        Random random = new Random();

        if(tempMember == null) {
            List<Nickname> nicknameListType1 = nicknameRepository.findNicknameByNicknameType(type1);
            List<Nickname> nicknameListType2 = nicknameRepository.findNicknameByNicknameType(type2);
            List<Nickname> nicknameListType3 = nicknameRepository.findNicknameByNicknameType(type3);

            String nickname = nicknameListType1.get(random.nextInt(nicknameListType1.size())).getNickname() + " " + nicknameListType2.get(random.nextInt(nicknameListType2.size())).getNickname() + " " +
                    nicknameListType3.get(random.nextInt(nicknameListType3.size())).getNickname();

            Member member = memberRepository.save(Member.toAdd(memberDto, nickname));

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
