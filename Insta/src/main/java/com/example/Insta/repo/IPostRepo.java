package com.example.Insta.repo;

import com.example.Insta.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Integer> {
}
