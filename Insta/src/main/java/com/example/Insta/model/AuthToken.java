package com.example.Insta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
public class AuthToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String tokenValue;
    private LocalDateTime tokenCreationDateTime;

    @OneToOne
    @JoinColumn(name = "fk_userId")
    user user;

    public AuthToken(user user)
    {
        this.user = user;
        this.tokenValue = UUID.randomUUID().toString();
        this.tokenCreationDateTime = LocalDateTime.now();
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public LocalDateTime getTokenCreationDateTime() {
        return tokenCreationDateTime;
    }

    public void setTokenCreationDateTime(LocalDateTime tokenCreationDateTime) {
        this.tokenCreationDateTime = tokenCreationDateTime;
    }

    public com.example.Insta.model.user getUser() {
        return user;
    }

    public void setUser(com.example.Insta.model.user user) {
        this.user = user;
    }
}
