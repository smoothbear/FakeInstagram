package com.kjbin0420.fakeinstagram.Repository;

import com.kjbin0420.fakeinstagram.Entity.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData, Integer> {
    UserData findByUserId(String userId);
}