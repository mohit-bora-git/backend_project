package com.jecrc.cheggbookmanagement.service;

import com.jecrc.cheggbookmanagement.model.entities.UserInfo;
import com.jecrc.cheggbookmanagement.model.requests.CreateUserRequestDto;

import java.util.List;
import java.util.Optional;

public interface UserService{

    UserInfo createUserInfo(CreateUserRequestDto createUserRequestDto);

    List<UserInfo> fetchAllUser();

    Optional<UserInfo> fetchUserById(Integer id);
}
