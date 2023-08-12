package com.likelion.thinker.service;

import com.likelion.thinker.entity.Member;
import com.likelion.thinker.entity.Post;
import com.likelion.thinker.entity.PostLike;
import com.likelion.thinker.repository.MemberRepository;
import com.likelion.thinker.repository.PostLikeRepository;
import com.likelion.thinker.repository.PostRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class PostLikeService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final PostLikeRepository postLikeRepository;

    @Transactional
    public Long addPostLike(Long memberId, Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);
        PostLike postLike;

        if(postLikeRepository.findPostLikeByMemberIdAndPostId(memberId, postId) == null) {
            postLike = postLikeRepository.save(PostLike.toAdd(member, post));
            return postLike.getPostLikeId();
        } else {
            return null;
        }
    }

    @Transactional
    public Long deletePostLike(Long memberId, Long postId) {
        PostLike postLike = postLikeRepository.findPostLikeByMemberIdAndPostId(memberId, postId);

        if(postLike != null) {
            Long responseId = postLike.getPostLikeId();
            postLikeRepository.delete(postLike);

            return responseId;
        } else {
            return null;
        }
    }
}
