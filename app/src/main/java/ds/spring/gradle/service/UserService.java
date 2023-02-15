package ds.spring.gradle.service;

import ds.spring.gradle.entity.UserEntity;
import ds.spring.gradle.restful.vo.UserVO;

import java.util.List;

public interface UserService {

    List<UserEntity> listUser();

    boolean addUser(UserVO userVO);
}
