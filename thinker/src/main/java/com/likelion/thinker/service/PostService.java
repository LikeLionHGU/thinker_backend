package com.likelion.thinker.service;

import com.likelion.thinker.dto.PostDto;
import com.likelion.thinker.entity.Post;
import com.likelion.thinker.repository.MemberRepository;
import com.likelion.thinker.repository.PostRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long addPost(Long memberId, PostDto postDto) {
        Post post = postRepository.save(Post.addPost(postDto, memberRepository.findByMemberId(memberId)));

        return post.getPostId();
    }

    @Transactional
    public PostDto getPost(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        PostDto postDto = PostDto.toResponse(post);

        return postDto;
    }

    @Transactional
    public List<PostDto> getAllPost() {
        List<Post> postList = postRepository.findAll();
        List<PostDto> postDtoList = postList.stream().map(PostDto::toResponse).collect(Collectors.toList());

        return postDtoList;
    }

}
