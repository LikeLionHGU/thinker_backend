package com.likelion.thinker.service;

import com.likelion.thinker.dto.NicknameDto;
import com.likelion.thinker.entity.Nickname;
import com.likelion.thinker.repository.NicknameRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class NicknameService {
    private final NicknameRepository nicknameRepository;

    public Long addNickName(NicknameDto nicknameDto) {
        Nickname nickname = nicknameRepository.save(Nickname.toNickname(nicknameDto));

        return nickname.getNicknameId();
    }
}
