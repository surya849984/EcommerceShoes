package com.Ecom.Project03.Repo;

import com.Ecom.Project03.entity.UserEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    
    public interface UserService {
        List<UserEntity> searchUsers(String keyword);
    }


}

