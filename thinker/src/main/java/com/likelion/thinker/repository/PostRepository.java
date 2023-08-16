package com.likelion.thinker.repository;

import com.likelion.thinker.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
// left join
public interface PostRepository extends JpaRepository<Post, Long> {
}

