package com.likelion.thinker.service;

import com.likelion.thinker.dto.CommentLikeDto;
import com.likelion.thinker.entity.Comment;
import com.likelion.thinker.entity.CommentLike;
import com.likelion.thinker.entity.Member;
import com.likelion.thinker.repository.CommentLikeRepository;
import com.likelion.thinker.repository.CommentRepository;
import com.likelion.thinker.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentLikeService {
    private final CommentLikeRepository commentLikeRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long addCommentLike(Long memberId, Long commentId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        Comment comment = commentRepository.findById(commentId).orElse(null);
        CommentLike commentLike = null;

        if(commentLikeRepository.findCommentLikeByMemberIdAndCommentId(memberId, commentId) == null) {
            commentLike = commentLikeRepository.save(CommentLike.toAdd(member, comment));

            return commentLike.getCommentLikeId();
        } else {
            return null;
        }
    }

    @Transactional
    public Long deleteCommentLike(Long memberId, Long commentId) {
        CommentLike commentLike = commentLikeRepository.findCommentLikeByMemberIdAndCommentId(memberId, commentId);
        if(commentLike != null) {
            Long responseId = commentLike.getCommentLikeId();
            commentLikeRepository.delete(commentLike);
            return responseId;
        } else {
            return null;
        }
    }
}
