package com.upstack.test.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upstack.test.configurations.CredentialsConfig;
import com.upstack.test.dto.UserCredential;
import com.upstack.test.dto.UserViewObject;
import com.upstack.test.exceptions.UserCredentialAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    private final CredentialsConfig credentialsConfig;
    private final ObjectMapper mapper;

    @Autowired
    public UsersService(CredentialsConfig credentialsConfig) {
        this.credentialsConfig = credentialsConfig;
        mapper = new ObjectMapper();
    }

    public void checkIfCredentialUserAlreadyExists(UserViewObject userViewObject) {
        for (UserViewObject uvo: getCredentialUsers()) {
            if (uvo.equals(userViewObject)) {
                throw new UserCredentialAlreadyExistException();
            }
        }
    }

    public List<UserViewObject> getCredentialUsers() {
        try {
            File credentialsFile = credentialsConfig.getResourceFile().getFile();
            String credentialRecords = new String(Files.readAllBytes(credentialsFile.toPath()));
            return mapper.readValue(credentialRecords, UserCredential.class).getUsers();
        } catch (Exception e) {}
        return new ArrayList<>();
    }
}
