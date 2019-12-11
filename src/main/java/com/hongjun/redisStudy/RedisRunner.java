package com.hongjun.redisStudy;

import com.hongjun.redisStudy.account.Account;
import com.hongjun.redisStudy.account.AccountRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    AccountRepo accountRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.warn("------ insert redis ------");
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("name", "hongjun");
        values.set("age", "29");
        values.set("fruit", "apple");

        Account account = new Account("1", "hongun2", "test2@test.co.kr");

        accountRepo.save(account);

        Optional<Account> byId = accountRepo.findById(account.getId());

        log.info("insert username: {}", byId.get().getUserName());
        log.info("insert email: {}", byId.get().getEmail());

    }
}
