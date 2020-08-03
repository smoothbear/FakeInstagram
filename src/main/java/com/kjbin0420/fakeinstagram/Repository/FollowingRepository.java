package com.kjbin0420.fakeinstagram.Repository;

import com.kjbin0420.fakeinstagram.Entity.Following;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowingRepository extends CrudRepository<Following, Integer> {
    List<Following> findAllByUserId(String userId);
}
