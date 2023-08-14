package com.likelion.thinker.repository;

import com.likelion.thinker.entity.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMarkRepository extends JpaRepository<BookMark, String> {
}
