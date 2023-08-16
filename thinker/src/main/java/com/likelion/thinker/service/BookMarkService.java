package com.likelion.thinker.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Permission;
import com.likelion.thinker.dto.BookMarkDto;
import com.likelion.thinker.entity.BookMark;
import com.likelion.thinker.entity.Member;
import com.likelion.thinker.repository.BookMarkRepository;
import com.likelion.thinker.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
@RequiredArgsConstructor
public class BookMarkService {
    private final MemberRepository memberRepository;
    private final BookMarkRepository bookMarkRepository;

    @Value("${cloud.accessKey}")
    private String accessKey;

    @Value("${cloud.secretKey}")
    private String secretKey;

    @Value("{cloud.endPoint}")
    private String endPoint;

    private final AmazonS3 amazonS3;

    @Transactional
    public String addBookMark(BookMarkDto bookMarkDto) {
        final String bucketName = "thinkey";
        Member member = memberRepository.findByMemberId(bookMarkDto.getUserId());
        BookMark tempBookMark = bookMarkRepository.findByBookMarkIdAndMemberId(member.getMemberId(), bookMarkDto.getUrl());

        String responseId = null;

        if (tempBookMark == null) {
            String objectName = bookMarkDto.getUserId() + "_" + System.currentTimeMillis() + "_" + bookMarkDto.getFile().getOriginalFilename();

            try {
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentLength(bookMarkDto.getFile().getSize());
                objectMetadata.setContentType(bookMarkDto.getFile().getContentType());
                amazonS3.putObject(bucketName, objectName, bookMarkDto.getFile().getInputStream(), objectMetadata);

                String uploadedImageUrl = String.format("%s/%s/%s", endPoint, bucketName, URLEncoder.encode(objectName, "UTF-8").replace("+", "%20"));
                AccessControlList accessControlList = amazonS3.getObjectAcl(bucketName, objectName);
                accessControlList.grantPermission(GroupGrantee.AllUsers, Permission.Read);

                amazonS3.setObjectAcl(bucketName, objectName, accessControlList);

                BookMark bookMark = bookMarkRepository.save(BookMark.toBookMark(bookMarkDto, member, uploadedImageUrl));
                responseId = bookMark.getUrl();

            } catch (UnsupportedEncodingException e) {

            } catch (IOException e) {

            }
            return responseId;
        } else {
            return null;
        }
    }

    @Transactional
    public String deleteBookMak(BookMarkDto bookMarkDto) {
        Member member = memberRepository.findByMemberId(bookMarkDto.getUserId());
        BookMark bookMark = bookMarkRepository.findByBookMarkIdAndMemberId(member.getMemberId(), bookMarkDto.getUrl());

        if(bookMark == null) {
            return null;
        } else {
            bookMarkRepository.delete(BookMark.toBookMark(bookMarkDto, member, bookMark.getFileUrl()));

            return bookMarkDto.getUrl();
        }
    }
}
