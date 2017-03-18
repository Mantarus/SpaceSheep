package com.ottepel_hack.services;

import com.ottepel_hack.entities.User;
import com.ottepel_hack.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by iistomin on 18/03/17.
 */
@Repository
public class UserService extends Service<UserRepository, User, String> {

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
    }

}
