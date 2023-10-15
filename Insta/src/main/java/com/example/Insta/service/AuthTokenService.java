package com.example.Insta.service;

import com.example.Insta.model.AuthToken;
import com.example.Insta.repo.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {

    @Autowired
    ITokenRepo iTokenRepo;

    public void createToken(AuthToken token) {
        iTokenRepo.save(token);
    }

    public boolean authenticate(String email,String tokenValue) {


        //find thr actual token -> get the connected patient -> get its email-> verify with passed email

        //return ipTokenRepo.findFirstByTokenValue(tokenValue).getPatient().getPatientEmail().equals(email);

        AuthToken token =  iTokenRepo.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getUser().getEmail().equals(email);
        }
        else
        {
            return false;
        }
    }
}
