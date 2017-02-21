package com.samray.repositories;

import com.samray.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 2/7/17
 */
public interface UserRepository extends JpaRepository<User,Long>{
   @Query("select  u from User u left join fetch u.roles r where u.username=:username")
   public Optional<User> findByUsername(@Param("username") String username);
}
