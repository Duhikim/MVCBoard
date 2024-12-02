package com.example.mywebservice.User.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // JPA에서 제공해주는 기본 CRUD 기능 외에 쿼리메소드 작성해서 추가 기능 구현 가능
    // 이메일 기반으로 사용자 정보 조회
    // select * from users where email = #{email}
    List<UserEntity> findByEmail(String email);
}
