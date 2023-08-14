package com.likelion.thinker.controller;

import com.likelion.thinker.dto.BookMarkDto;
import com.likelion.thinker.dto.request.BookMarkRequest;
import com.likelion.thinker.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookmark")
public class BookMarkController {
    private final BookMarkService bookMarkService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<String> addBookMark(@PathVariable Long userId, @RequestBody BookMarkRequest bookMarkRequest) {
        String responseId = bookMarkService.addBookMark(BookMarkDto.toBookMarkDto(bookMarkRequest, userId));

        return ResponseEntity.ok(responseId);
    }

    @DeleteMapping("/delete/{userId}/{bookMarkId}")
    public ResponseEntity<String> deleteBookMark(@PathVariable Long userId, @PathVariable String bookMarkId) {
        String responseId = bookMarkService.deleteBookMak(BookMarkDto.toBookMarkDto(bookMarkId, userId));

        return ResponseEntity.ok(responseId);
    }
}
