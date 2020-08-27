package com.kjbin0420.fakeinstagram.Repository.User;

import com.kjbin0420.fakeinstagram.Entity.User.Follower;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FollowerRepository extends CrudRepository<Follower, Integer> {
    Optional<List<Follower>> findAllByUserId(String userId);
}