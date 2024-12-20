package org.service;

import org.apache.ibatis.session.SqlSession;
import org.entity.Article;
import org.entity.Message;
import org.mapper.ArticleMapper;
import org.util.MybatisUtil;

import java.util.List;

public class ArticleService {
    public boolean UploadArticle(String title, String Content, int AuthorID,String CreateTime) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.UploadArticleByUser(title, Content, AuthorID, CreateTime);
        }
    }

    public List<Article> getAllArticle() {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.getAllArticle();
        }
    }

    public Article getNowArticle(int ArticleId) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.getNowArticleByArticleId(ArticleId);
        }
    }

    public boolean AddFavorArticle(int UserId,int ArticleId,String CreateTime) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.AddFavorArticle(UserId,ArticleId,CreateTime);
        }
    }
    public List<Article> getAllFavorArticle(int UserId) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.getAllFavorArticleByUserId(UserId);
        }
    }

    public List<Message> getAllMessageByArticleId(int ArticleId) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.getAllMessageByArticleId(ArticleId);
        }
    }

    public boolean addMessageByUserId(String Content,int UserId,int ArticleId,String CreatTime) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.addMessageByUserId(Content, UserId, ArticleId, CreatTime);
        }
    }

}
