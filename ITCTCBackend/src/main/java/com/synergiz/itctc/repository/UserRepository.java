package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


	@Query("""
		       SELECT u
		       FROM User u
		       JOIN FETCH u.role
		       WHERE LOWER(u.username) = LOWER(:username)
		       """)
		Optional<User> findByUsername(@Param("username") String username);

 
    Optional<User> findByEmail(String email);


    Optional<User> findByMobileNumber(String mobileNumber);

    boolean existsByUsername(String username);

 
    boolean existsByEmail(String email);


    boolean existsByMobileNumber(String mobileNumber);

}