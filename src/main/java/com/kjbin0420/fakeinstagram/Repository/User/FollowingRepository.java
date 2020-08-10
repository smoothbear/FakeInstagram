package com.kjbin0420.fakeinstagram.Repository.User;

import com.kjbin0420.fakeinstagram.Entity.User.Following;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowingRepository extends CrudRepository<Following, Integer> {
    List<Following> findAllByUserId(String userId);
}