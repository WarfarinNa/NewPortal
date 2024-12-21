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

    public boolean AddFavorArticle(int UserId,int ArticleId,String CreateTime,String ArticleTitle) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.AddFavorArticle(UserId,ArticleId,CreateTime,ArticleTitle);
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

    public List<Article> findArticlesByTitle(String ArticleTitle) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.findArticlesByTitle(ArticleTitle);
        }
    }

    public void deleteMessageByMessageId(int messageId) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            mapper.deleteMessageByMessageId(messageId);
        }
    }

    public int getUserIdByMessageId(int messageId) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.getUserIdByMessageId(messageId);
        }
    }

    public List<Article> findArticlesByUserId(int UserId) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.findArticlesByUserId(UserId);
        }
    }

    public void UpdateArticleByArticleId(String title,String content,String createTime,int ArticleId) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            mapper.UpdateArticleByArticleId(title, content, createTime, ArticleId);
        }
    }

    public void deleteFavorArticleByFavorId(int ArticleId,int UserId) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            mapper.deleteFavorArticleByFavorId(ArticleId,UserId);
        }
    }

    public List<Article> getArticlesByPage(int pageNum, int pageSize) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            int offset = (pageNum - 1) * pageSize; // 计算偏移量
            return mapper.getArticlesByPage(offset, pageSize);
        }
    }

    public int getTotalArticleCount() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.getTotalArticleCount();
        }
    }

    public Article getAllFromTempArticleByUserId(int userId) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            return mapper.getAllFromTempArticleByUserId(userId);
        }
    }

    public void addTempArticle(int UserId,String Title,String Content) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            int count = mapper.checkTempArticleExist(UserId);
            if (count > 0) {
                mapper.updateTempArticle(UserId, Title, Content);
            } else {
                mapper.addTempArticle(UserId, Title, Content);
            }
        }
    }

    public void deleteTempArticle(int UserId) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            mapper.deleteTempArticle(UserId);
        }
    }
}
