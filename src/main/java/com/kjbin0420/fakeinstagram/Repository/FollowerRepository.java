package com.kjbin0420.fakeinstagram.Repository;

import com.kjbin0420.fakeinstagram.Entity.Follower;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowerRepository extends CrudRepository<Follower, Integer> {
    List<Follower> findAllByUserId(String userId);
}
