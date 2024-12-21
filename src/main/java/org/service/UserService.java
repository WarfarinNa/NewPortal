package org.service;

import org.apache.ibatis.session.SqlSession;
import org.entity.User;
import org.mapper.UserMapper;
import org.util.MybatisUtil;

public class UserService {
    public boolean upDateUserInfoByUserName(String username, String password, String sex,String signature) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.upDateUserInfoByUserName(username, password, sex, signature);
        }
    }

    public String findUserRoleByUserName(String username) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.findUserRoleByUserName(username);
        }
    }

    public User getNowUserInfoByUserName(String username) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.getNowUserInfoByUserName(username);
        }
    }

    public void addUserInfo(String username, String password, String sex) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.addUserInfo(username, password, sex);
        }
    }
}
