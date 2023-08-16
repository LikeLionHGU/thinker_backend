package com.likelion.thinker.entity;

import com.likelion.thinker.dto.CommentDto;
import com.likelion.thinker.dto.PostDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<CommentLike> commentLikeList = new ArrayList<CommentLike>();

    @Transient
    private Boolean isLiked;

    private String content;

    public static Comment toAdd(CommentDto commentDto, Member member, Post post) {
        return Comment.builder()
                .member(member)
                .post(post)
                .content(commentDto.getContent())
                .build();
    }
}
