package com.likelion.thinker.service;

import com.likelion.thinker.dto.PostDto;
import com.likelion.thinker.entity.CommentLike;
import com.likelion.thinker.entity.Member;
import com.likelion.thinker.entity.Post;
import com.likelion.thinker.entity.PostLike;
import com.likelion.thinker.repository.CommentLikeRepository;
import com.likelion.thinker.repository.MemberRepository;
import com.likelion.thinker.repository.PostLikeRepository;
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
    private final PostLikeRepository postLikeRepository;
    private final CommentLikeRepository commentLikeRepository;

    @Transactional
    public Long addPost(Long memberId, PostDto postDto) {
        Post post = postRepository.save(Post.addPost(postDto, memberRepository.findByMemberId(memberId)));

        return post.getPostId();
    }

    @Transactional
    public PostDto getPost(Long postId, Long memberId) {
        PostLike postLike = postLikeRepository.findPostLikeByMemberIdAndPostId(memberId, postId);
        Post post = postRepository.findById(postId).orElse(null);
        PostDto postDto;

        if(postLike == null) {
            postDto = PostDto.toResponse(post, false);
        } else {
            postDto = PostDto.toResponse(post, true);
        }

        for(int i = 0; i < postDto.getCommentList().size(); i++) {
            CommentLike commentLike = commentLikeRepository.findCommentLikeByMemberIdAndCommentId(memberId,
                    postDto.getCommentList().get(i).getCommentId());

            if(commentLike != null) {
                postDto.getCommentList().get(i).setIsLiked(true);
            } else {
                postDto.getCommentList().get(i).setIsLiked(false);
            }
        }


        return postDto;
    }

    @Transactional
    public List<PostDto> getAllPost(Long userId) {
        List<Post> postList = postRepository.findAll();

        for(int i = 0; i < postList.size(); i++) {
            PostLike postLike = postLikeRepository.findPostLikeByMemberIdAndPostId(userId, postList.get(i).getPostId());

            if(postLike != null) {
                postList.get(i).setIsLike(true);
            } else {
                postList.get(i).setIsLike(false);
            }
        }

        List<PostDto> postDtoList = postList.stream().map(PostDto::toResponse).collect(Collectors.toList());


        return postDtoList;
    }

}
