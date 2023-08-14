package com.likelion.thinker.controller;

import com.likelion.thinker.dto.MemberDto;
import com.likelion.thinker.dto.request.MemberRequest;
import com.likelion.thinker.dto.response.member.MemberResponse;
import com.likelion.thinker.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Long> addUser(@RequestBody MemberRequest memberRequest) {
        MemberDto memberDto = MemberDto.toAdd(memberRequest);
        Long memberId = memberService.addUser(memberDto);

        return ResponseEntity.ok(memberId);
    }

    @GetMapping("{userId}")
    public ResponseEntity<MemberResponse> getUser(@PathVariable Long userId) {
        MemberDto memberDto = memberService.getUser(userId);
        MemberResponse memberResponse = MemberResponse.toResponse(memberDto);

        return ResponseEntity.ok(memberResponse);
    }

}
