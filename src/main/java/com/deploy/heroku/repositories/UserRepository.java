package com.deploy.heroku.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deploy.heroku.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
