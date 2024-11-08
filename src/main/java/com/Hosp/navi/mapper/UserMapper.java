package com.Hosp.navi.mapper;

import com.Hosp.navi.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void saveUser(User user);

    User findByEmail(String email);
}
