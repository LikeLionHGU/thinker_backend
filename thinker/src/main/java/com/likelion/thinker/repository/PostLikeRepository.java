package com.likelion.thinker.repository;

import com.likelion.thinker.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    @Query("select r from PostLike r where r.member.memberId = :memberId And r.post.postId = :postId")
    PostLike findPostLikeByMemberIdAndPostId(Long memberId, Long postId);
}
