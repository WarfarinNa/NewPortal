package org.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.entity.User;

public interface UserMapper {
    @Select("select * from userinfo where UserName = #{username} and PassWord = #{password}")
    User getUserByNameAndPassWord (@Param("username")String username, @Param("password")String password);

    @Update("update userinfo set PassWord=#{password},Sex=#{sex},Signature=#{signature} where UserName=#{username}")
    Boolean upDateUserInfoByUserName(@Param("username")String username,@Param("password")String password
            ,@Param("sex")String sex,@Param("signature")String signature);

    @Select("SELECT Role from userinfo where UserName=#{username}")
    String findUserRoleByUserName(@Param("username")String username);

    @Select("select * from userinfo where UserName = #{username}")
    User getNowUserInfoByUserName (@Param("username")String username);

}
