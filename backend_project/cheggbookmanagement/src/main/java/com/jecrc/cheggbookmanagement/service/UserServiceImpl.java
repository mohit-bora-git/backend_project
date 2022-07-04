package com.jecrc.cheggbookmanagement.service;

import com.jecrc.cheggbookmanagement.model.entities.UserInfo;
import com.jecrc.cheggbookmanagement.model.requests.CreateUserRequestDto;
import com.jecrc.cheggbookmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public UserInfo createUserInfo(CreateUserRequestDto createUserRequestDto){
        UserInfo userInfo=createUserRequestDto.toUser();
        /*persisting the userinfo to database*/
        return userRepository.save(userInfo);
    }

    @Override
    public List<UserInfo> fetchAllUser(){
        return userRepository.findAll();
    }

    @Override
    public Optional<UserInfo> fetchUserById(Integer id){
        return userRepository.findById(id);
    }

}
