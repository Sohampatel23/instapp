package com.example.Insta.service;

import com.example.Insta.model.Post;
import com.example.Insta.repo.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    IPostRepo iPostRepo;

    public void createInstaPost(Post instaPost) {
        iPostRepo.save(instaPost);
    }

    public Post getPostById(Integer postId) {
        return  iPostRepo.findById(postId).orElseThrow();

    }
}
