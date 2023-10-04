package com.paladin.account.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImplTest.class);

    @Test
    void getVerifyCode() throws NoSuchAlgorithmException {
        SecureRandom random = null;
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException exp) {
            LOGGER.error("no such algorithm exception", exp);
            throw new NoSuchAlgorithmException(exp);
        }
        Integer result = random.nextInt(100);
        LOGGER.info("result is {}", result);

        Integer local = ThreadLocalRandom.current().nextInt(100000, 999999);
        LOGGER.info("local is {}", local);
    }

}