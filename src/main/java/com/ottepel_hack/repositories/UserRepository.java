package com.ottepel_hack.repositories;

import com.ottepel_hack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by iistomin on 18/03/17.
 */
public interface UserRepository extends JpaRepository<User, String> {
}
