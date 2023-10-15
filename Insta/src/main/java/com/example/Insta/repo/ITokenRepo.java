package com.example.Insta.repo;

import com.example.Insta.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthToken,Long> {

    AuthToken findFirstByTokenValue(String authTokenValue);
}
