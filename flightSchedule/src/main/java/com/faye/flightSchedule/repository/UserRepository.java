package com.faye.flightSchedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.faye.flightSchedule.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User u where u.etaAccount=:etaAccount")
    User findUser(@Param("etaAccount") String wxAccount);


}
