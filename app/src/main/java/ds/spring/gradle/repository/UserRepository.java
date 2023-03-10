package ds.spring.gradle.repository;

import ds.spring.gradle.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query("select t from UserEntity t ")
    List<UserEntity> queryAllData();
}
