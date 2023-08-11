package com.likelion.thinker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.likelion.thinker.dto.PostDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "postLike", cascade = CascadeType.ALL)
    private List<PostLike> postLikeList;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Comment> commentList;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(updatable = false)
    private LocalDateTime date;

    private String title;

    private String content;

    public static Post addPost(PostDto postDto, Member member) {
        return Post.builder()
                .member(member)
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .build();
    }
}
