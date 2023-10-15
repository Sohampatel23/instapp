package com.example.Insta.repo;

import com.example.Insta.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<user,Integer> {
    user findFirstByUserEmail(String newEmail);

}
