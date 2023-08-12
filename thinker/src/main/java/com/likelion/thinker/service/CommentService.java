package com.likelion.thinker.service;

import com.likelion.thinker.dto.CommentDto;
import com.likelion.thinker.dto.PostDto;
import com.likelion.thinker.entity.Comment;
import com.likelion.thinker.entity.Member;
import com.likelion.thinker.entity.Post;
import com.likelion.thinker.repository.CommentRepository;
import com.likelion.thinker.repository.MemberRepository;
import com.likelion.thinker.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public Long addComment(Long memberId, Long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);
        Comment comment = commentRepository.save(Comment.toAdd(commentDto, member, post));

        return comment.getCommentId();
    }
}
