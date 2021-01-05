package com.deploy.heroku.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deploy.heroku.models.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
