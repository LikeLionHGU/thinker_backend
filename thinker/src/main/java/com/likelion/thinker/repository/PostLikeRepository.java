package com.likelion.thinker.repository;

import com.likelion.thinker.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    @Query("select r from PostLike r where r.member.memberId = :memberId And r.post.postId = :postId")
    PostLike findPostLikeByMemberIdAndPostId(@Param("memberId") String memberId, @Param("postId") Long postId);
}
