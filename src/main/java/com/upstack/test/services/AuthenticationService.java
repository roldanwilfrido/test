package com.upstack.test.services;

import com.upstack.test.dto.ResponseDTO;
import com.upstack.test.dto.UserViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UsersService usersService;

    @Autowired
    public AuthenticationService(UsersService usersService) {
        this.usersService = usersService;
    }

    public ResponseDTO checkCredentials(UserViewObject userViewObject) {
        Boolean isCredentialOK = isCredentialOK(userViewObject);
        return ResponseDTO.builder().result(isCredentialOK).build();
    }

    private Boolean isCredentialOK(UserViewObject userViewObject) {
        for (UserViewObject uvo: usersService.getCredentialUsers()) {
            if (uvo.equals(userViewObject)) {
                return true;
            }
        }
        return false;
    }

    public ResponseDTO saveCredentials(UserViewObject userViewObject) {
        usersService.checkIfCredentialUserAlreadyExists(userViewObject);
        return ResponseDTO.builder().result(true).build();
    }
}
