package com.hongjun.redisStudy.account;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, String> {
}
