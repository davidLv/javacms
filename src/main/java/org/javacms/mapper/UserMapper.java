package org.javacms.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.javacms.beans.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    /**
     * login method
     * @param username
     * @param password
     * @return
     */
    @Select("select * from jo_user where username=#{username} and password=#{password}")
    @Results({
        @Result(id=true, property="userId", column="user_id", javaType=Integer.class),
        @Result(property="username", column="username", javaType=String.class),
        @Result(property="password", column="password", javaType=String.class)
    })
    public User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
