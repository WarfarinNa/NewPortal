package org.service;

import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.entity.User;
import org.mapper.UserMapper;
import org.util.MybatisUtil;

public class LoginService {
    public boolean auth(String username, String password, HttpSession session) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserByNameAndPassWord(username,password);
            if (user == null) {
                return false;
            }
            session.setAttribute("user",user);
            return true;
        }
    }
}
