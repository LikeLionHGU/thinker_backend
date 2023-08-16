package com.likelion.thinker.repository;

import com.likelion.thinker.entity.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookMarkRepository extends JpaRepository<BookMark, String> {
    @Query("select r from BookMark r where r.member.memberId = :memberId And r.url = :url")
    BookMark findByBookMarkIdAndMemberId(@Param("memberId") Long memberId, @Param("url") String url);
}
