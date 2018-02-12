package com.vanin.techdemo;

import org.springframework.data.repository.Repository;

public interface UsersRepository extends Repository<User, Long> {
    User findByName(String name);
}
