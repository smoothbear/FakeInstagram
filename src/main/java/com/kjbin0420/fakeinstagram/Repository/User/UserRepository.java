package com.kjbin0420.fakeinstagram.Repository.User;

import com.kjbin0420.fakeinstagram.Entity.User.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserData, Integer> {
    Optional<UserData> findByUserId(String userId);
}