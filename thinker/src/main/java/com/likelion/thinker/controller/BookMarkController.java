package com.likelion.thinker.controller;

import com.likelion.thinker.dto.BookMarkDto;
import com.likelion.thinker.dto.request.BookMarkDeleteRequest;
import com.likelion.thinker.dto.request.BookMarkRequest;
import com.likelion.thinker.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookmark")
@CrossOrigin(origins = "*")
public class BookMarkController {
    private final BookMarkService bookMarkService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<String> addBookMark(@PathVariable Long userId, @RequestPart("content") BookMarkRequest bookMarkRequest, @RequestParam("file") MultipartFile file) {
        String responseId = bookMarkService.addBookMark(BookMarkDto.toBookMarkDto(bookMarkRequest, userId, file));

        return ResponseEntity.ok(responseId);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteBookMark(@PathVariable Long userId, @RequestBody BookMarkDeleteRequest bookMarkDeleteRequest) {
        String responseId = bookMarkService.deleteBookMak(BookMarkDto.toBookMarkDto(bookMarkDeleteRequest.getUrl(), userId));

        return ResponseEntity.ok(responseId);
    }
}
