package com.likelion.thinker.controller;

import com.likelion.thinker.dto.NicknameDto;
import com.likelion.thinker.service.NicknameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nickname")
@CrossOrigin(origins = "*")
public class NicknameController {
    private final NicknameService nicknameService;

    @Transactional
    @PostMapping
    public ResponseEntity<Long> postNickname(@RequestBody NicknameDto nicknameDto) {
        Long nicknameId = nicknameService.addNickName(nicknameDto);

        return ResponseEntity.ok(nicknameId);
    }
}
