package com.app.repository;

import com.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User> findByName(String name);
    public List<User> findByStatusOrderByIdDesc(String status);

    @Query("SELECT u FROM User u WHERE u.city=:city")
    public List<User> usersByCity(@Param("city") String city);

    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getUsers();

}
