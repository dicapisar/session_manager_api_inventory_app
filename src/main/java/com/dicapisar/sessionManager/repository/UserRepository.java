package com.dicapisar.sessionManager.repository;

import com.dicapisar.sessionManager.models.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.name =:name and u.isActive = true")
    User getUserByIdAndIsActive(@Param("name") String name);
}
