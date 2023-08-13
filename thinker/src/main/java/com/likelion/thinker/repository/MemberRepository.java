package com.likelion.thinker.repository;

import com.likelion.thinker.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select r from Member r where r.memberId = :memberId")
    Member findByMemberId(@Param("memberId") String memberId);
}
