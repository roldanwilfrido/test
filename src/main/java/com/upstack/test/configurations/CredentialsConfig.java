package com.upstack.test.configurations;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@Getter
public class CredentialsConfig {
    @Value("classpath:static/credentials.json")
    private Resource resourceFile;
}
