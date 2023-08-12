package com.likelion.thinker.dto.response.postLike;

import com.likelion.thinker.dto.response.post.PostByPostLikeResponse;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostLikeByMemberResponse {
    private Long postLikeId;

    private PostByPostLikeResponse post;

    public static PostLikeByMemberResponse toPostLikeByMemberResponse(PostLikeDto postLikeDto) {
        return PostLikeByMemberResponse.builder()
                .postLikeId(postLikeDto.getPostLikeId())
                .post(PostByPostLikeResponse.toPostByPostLikeResponse(postLikeDto.getPost()))
                .build();
    }
}
