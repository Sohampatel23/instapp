package com.example.Insta.service;

import com.example.Insta.HashingUtils.passwordEncryptor;
import com.example.Insta.emailUtility.EmailHandler;
import com.example.Insta.model.AuthToken;
import com.example.Insta.model.Post;
import com.example.Insta.model.user;
import com.example.Insta.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    AuthTokenService authTokenService;

    @Autowired
    PostService postService;

    public String userSignUp(user newUser) {

        String email = newUser.getEmail();
        user existuser = iUserRepo.findFirstByUserEmail(email);
        if(existuser!=null)
        {
            return "User Already Exist";
        }

        String password = newUser.getPassword();

        try {
            String encryptedPassword = passwordEncryptor.encrypt(password);

            newUser.setPassword(encryptedPassword);


            // patient table - save patient
            iUserRepo.save(newUser);
            return "Insta user registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String userSignIn(String email, String password) {
        user existingUser = iUserRepo.findFirstByUserEmail(email);

        if(existingUser == null)
        {
            return "Not a valid email, Please sign up first !!!";
        }

        try {
            String encryptedPassword = passwordEncryptor.encrypt(password);

            if(existingUser.getPassword().equals(encryptedPassword))
            {
                // return a token for this sign in
                AuthToken token  = new AuthToken(existingUser);

                if(EmailHandler.sendEmail(email,"otp after login", token.getTokenValue())) {
                    authTokenService.createToken(token);
                    return "check email for otp/token!!!";
                }
                else {
                    return "error while generating token!!!";
                }

            }
            else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String createInstaPost(String email, String tokenValue, Post instaPost) {

        if(authTokenService.authenticate(email,tokenValue)) {

            user existingUser = iUserRepo.findFirstByUserEmail(email);
            instaPost.setUser(existingUser);

            postService.createInstaPost(instaPost);
            return  " posted!!";

        }
        else {
            return "Un Authenticated access!!!";
        }
    }
}
