package com.kjbin0420.fakeinstagram.Repository.User;

import com.kjbin0420.fakeinstagram.Entity.User.UserData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserData, Integer> {
    Optional<UserData> findByUserId(String userId);

    @Modifying
    @Transactional
    @Query(value = "update UserData u set u.userEmail = :#{#user.userEmail}, u.userPw = :#{#user.userPw}, u.userName = :#{#user.userName} WHERE u.UUID = :#{#user.UUID}", nativeQuery=false)
    void userProfileUpdate(@Param("user") UserData user);
}