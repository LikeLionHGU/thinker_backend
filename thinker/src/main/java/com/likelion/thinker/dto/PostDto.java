package com.likelion.thinker.dto;

import com.likelion.thinker.dto.response.postLike.PostLikeDto;
import com.likelion.thinker.entity.Post;
import com.likelion.thinker.dto.request.PostRequest;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PostDto {
    private Long postId;

    private String title;

    private String content;

    private LocalDateTime date;

    private MemberDto memberDto;

    private Integer totalPostLikeCount;

    private String writer;

    private List<PostLikeDto> postLikeList;

    private List<CommentDto> commentList;

    private Boolean isLiked;

    public static PostDto toAdd(PostRequest postRequest) {
        return PostDto.builder()
                .content(postRequest.getContent())
                .title(postRequest.getTitle())
                .build();
    }

    public static PostDto toResponse(Post post, Boolean isLiked) {
        return PostDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .date(post.getDate())
                .totalPostLikeCount(post.getPostLikeList().size())
                .memberDto(MemberDto.toPostResponse(post.getMember()))
                .postLikeList(post.getPostLikeList().stream().map(PostLikeDto::toResponse).collect(Collectors.toList()))
                .commentList(post.getCommentList().stream().map(CommentDto::toResponse).collect(Collectors.toList()))
                .isLiked(isLiked)
                .build();
    }

    public static PostDto toResponse(Post post) {
        return PostDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .date(post.getDate())
                .totalPostLikeCount(post.getPostLikeList().size())
                .memberDto(MemberDto.toPostResponse(post.getMember()))
                .postLikeList(post.getPostLikeList().stream().map(PostLikeDto::toResponse).collect(Collectors.toList()))
                .commentList(post.getCommentList().stream().map(CommentDto::toResponse).collect(Collectors.toList()))
                .isLiked(post.getIsLike())
                .build();
    }

    public static PostDto toMemberResponse(Post post) {
        return PostDto.builder()
                .writer(post.getMember().getName())
                .postId(post.getPostId())
                .title(post.getTitle())
                .date(post.getDate())
                .content(post.getContent())
                .totalPostLikeCount(post.getPostLikeList().size())
                .build();
    }
}
