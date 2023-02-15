package ds.spring.gradle.service.impl;

import com.alibaba.fastjson.JSON;
import ds.spring.gradle.entity.UserEntity;
import ds.spring.gradle.repository.UserRepository;
import ds.spring.gradle.restful.vo.UserVO;
import ds.spring.gradle.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mx.DigestUtils;
import org.mx.dal.service.GeneralAccessor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

    @Override
    public boolean addUser(UserVO userVO) {
        log.warn("userVO -> {}" , JSON.toJSONString(userVO));

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userVO , userEntity);
        userEntity.setId(DigestUtils.uuid());
        log.warn("userEntity -> {}" , JSON.toJSONString(userEntity));

        UserEntity savedUser = userRepository.save(userEntity);
        log.warn("savedUser -> {}" , JSON.toJSONString(savedUser));

        return !ObjectUtils.isEmpty(savedUser);
    }
}
