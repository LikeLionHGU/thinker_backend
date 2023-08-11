package com.likelion.thinker.entity;

import com.likelion.thinker.controller.CommentController;
import com.likelion.thinker.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @OneToMany(mappedBy = "postLike", cascade = CascadeType.ALL)
    private List<PostLike> postLikeList;

    @OneToMany(mappedBy = "commentLike", cascade = CascadeType.ALL)
    private List<CommentLike> commentLikeList;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Post> postList;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Comment> commentList;

    private String name;

    private String email;

    public static Member toAdd(MemberDto memberDto) {
        return Member.builder()
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .build();
    }
}
