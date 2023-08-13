package com.likelion.thinker.repository;

import com.likelion.thinker.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
    @Query("select r from CommentLike r where r.member.memberId = :memberId And r.comment.commentId = :commentId")
    CommentLike findCommentLikeByMemberIdAndCommentId(@Param("memberId") String memberId, @Param("commentId") Long commentId);
}
