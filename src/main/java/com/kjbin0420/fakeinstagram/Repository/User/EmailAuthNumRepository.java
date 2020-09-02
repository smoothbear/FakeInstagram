package com.kjbin0420.fakeinstagram.Repository.User;

import com.kjbin0420.fakeinstagram.Entity.User.EmailAuthNum;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EmailAuthNumRepository extends CrudRepository<EmailAuthNum, Integer> {
    public Optional<EmailAuthNum> findByNum(Integer num);

    @Modifying
    @Transactional
    @Query(value = "delete from EmailAuthNum where createdAt < :time")
    public void deleteNum(LocalDateTime time);
}