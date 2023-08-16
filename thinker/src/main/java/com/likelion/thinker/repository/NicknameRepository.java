package com.likelion.thinker.repository;

import com.likelion.thinker.entity.Nickname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NicknameRepository extends JpaRepository<Nickname, Long> {
    @Query("select r from Nickname r where r.nicknameType = :type")
    List<Nickname> findNicknameByNicknameType(@Param("type") Long type);
}
