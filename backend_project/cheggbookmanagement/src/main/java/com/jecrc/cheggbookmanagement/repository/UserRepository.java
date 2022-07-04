package com.jecrc.cheggbookmanagement.repository;

import com.jecrc.cheggbookmanagement.model.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {
}
