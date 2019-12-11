package com.hongjun.redisStudy.account;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash("accounts")
public class Account {

    @Id
    private String id;

    private String userName;

    private String email;

    public Account(String id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
