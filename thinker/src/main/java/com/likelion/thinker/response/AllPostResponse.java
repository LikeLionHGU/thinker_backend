package com.likelion.thinker.response;

import com.likelion.thinker.dto.MemberDto;
import com.likelion.thinker.dto.PostDto;
import com.likelion.thinker.dto.PostLikeDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AllPostResponse {
    private Long postId;

    private String title;

    private String content;

    private LocalDateTime date;

    private MemberDto memberDto;

    private List<PostLikeDto> postLikeDtoList;

    public static AllPostResponse toResponse(PostDto postDto) {
        return AllPostResponse.builder()
                .postId(postDto.getPostId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .date(postDto.getDate())
                .memberDto(postDto.getMemberDto())
                .postLikeDtoList(postDto.getPostLikeDtoList())
                .build();
    }
}
