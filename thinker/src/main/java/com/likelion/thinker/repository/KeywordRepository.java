package com.likelion.thinker.repository;

import com.likelion.thinker.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    @Query(value = "SELECT r FROM Keyword ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Keyword> findRandomThreeKeyword();
}
