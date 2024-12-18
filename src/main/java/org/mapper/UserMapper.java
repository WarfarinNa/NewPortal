package org.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.entity.User;

public interface UserMapper {
    @Select("select * from userinfo where UserName = #{username} and PassWord = #{password}")
    User getUserByNameAndPassWord (@Param("username")String username, @Param("password")String password);

}
