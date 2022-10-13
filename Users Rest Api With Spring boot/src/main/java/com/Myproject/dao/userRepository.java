package com.Myproject.dao;

import com.Myproject.Entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRepository extends CrudRepository<Users, Integer> {
    @Override
    List<Users> findAll();
}
