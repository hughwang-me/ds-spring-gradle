package ds.spring.gradle.service.impl;

import ds.spring.gradle.entity.UserEntity;
import ds.spring.gradle.repository.UserRepository;
import ds.spring.gradle.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> listUser() {
        return userRepository.findAll();
    }
}
