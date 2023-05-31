package com.Ecom.Project03.Repo;

import com.Ecom.Project03.entity.UserEntity;
import java.util.List;

public interface UserService {
    List<UserEntity> searchUsers(String keyword);
}
