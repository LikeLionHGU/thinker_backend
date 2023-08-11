package com.likelion.thinker.service;

import com.likelion.thinker.dto.PostDto;
import com.likelion.thinker.repository.PostRepository;
import com.likelion.thinker.request.PostRequest;
import com.likelion.thinker.response.PostResponse;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long addPost(Long userId, PostRequest postRequest) {

    }

    @Transactional
    public PostResponse getPost() {

    }

    @Transactional
    public List<PostResponse> getAllPost() {

    }

}
