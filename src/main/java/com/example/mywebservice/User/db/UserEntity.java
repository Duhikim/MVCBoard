package com.example.mywebservice.User.db;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 사용 범위 제한. 무결성 보호. 원치 않는 객체 사용 방지. 사용 안해서 문제되지는 않음.
public class UserEntity implements UserDetails { // UserDetails 인터페이스 상속 받아서 인증 객체로 사용한다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    private Long id;

    @Column(name="email", nullable = false, unique=true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Builder
    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }
    // 권한을 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        return true;
        //return UserDetails.super.isAccountNonExpired();
    }

    // 계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        return true;
        // return UserDetails.super.isAccountNonLocked();
    }

    // 패스워드 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
        // return UserDetails.super.isCredentialsNonExpired();
    }

    //
    @Override
    public boolean isEnabled() {
        return true;
        // return UserDetails.super.isEnabled();
    }
}
