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
        Member member = memberRepository.getById(memberId);
        Comment comment = commentRepository.getById(commentId);
        CommentLike commentLike = commentLikeRepository.save(CommentLike.toAdd(member, comment));

        return commentLike.getCommentLikeId();
    }

    @Transactional
    public Long deleteCommentLike(Long memberId, Long commentId) {
        CommentLike commentLike = commentLikeRepository.findCommentLikeByMemberIdAndCommentId(memberId, commentId);
        Long responseId = commentLike.getCommentLikeId();
        commentLikeRepository.delete(commentLike);

        return responseId;
    }
}
