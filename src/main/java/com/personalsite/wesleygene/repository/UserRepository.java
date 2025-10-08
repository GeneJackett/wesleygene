package com.personalsite.wesleygene.repository;

import com.personalsite.wesleygene.model.User;

public interface UserRepository {
    User findByUsername(String username);
}
