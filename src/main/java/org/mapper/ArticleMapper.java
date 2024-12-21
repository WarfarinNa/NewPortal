package org.mapper;

import org.apache.ibatis.annotations.*;
import org.entity.Article;
import org.entity.Message;

import java.util.List;

public interface ArticleMapper {
    @Insert("INSERT INTO article(Title, Content, AuthorID,CreateTime) " +
            "values(#{Title},#{Content},#{AuthorID},#{CreateTime})")
    Boolean  UploadArticleByUser(@Param("Title")String title,@Param("Content")String
            Content,@Param("AuthorID")int AuthorID,@Param("CreateTime")String CreateTime);

    @Select("SELECT * from article")
    List<Article> getAllArticle();

    @Select("SELECT * from article where ArticleId=#{ArticleId}")
    Article getNowArticleByArticleId(@Param("ArticleId")int ArticleId);

    @Insert("INSERT into favoritesarticle(UserId, ArticleId, CreateTime,Title) VALUES (#{UserId},#{ArticleId},#{CreateTime},#{ArticleTitle})")
    Boolean AddFavorArticle(@Param("UserId")int UserId,@Param("ArticleId")int ArticleId,@Param("CreateTime")String CreateTime,@Param("ArticleTitle")String ArticleTitle);

    @Select("SELECT * from favoritesarticle where UserId = #{UserId}")
    List<Article> getAllFavorArticleByUserId(@Param("UserId")int UserId);

    @Select("SELECT * from messageboard where ArticleId = #{ArticleId}")
    List<Message> getAllMessageByArticleId(@Param("ArticleId")int ArticleId);

    @Insert("INSERT into messageboard(Content, UserId,ArticleId,CreatTime) " +
            "VALUES (#{Content},#{UserId},#{ArticleId},#{CreatTime})")
    Boolean addMessageByUserId(@Param("Content")String Content,
                               @Param("UserId")int UserId,@Param("ArticleId")int ArticleId,@Param("CreatTime")String CreatTime);
    @Select("SELECT * FROM article WHERE Title LIKE CONCAT('%', #{articleTitle}, '%')")
    List<Article> findArticlesByTitle(@Param("articleTitle") String articleTitle);

    @Delete("Delete  FROM messageboard where MessageId = #{messageId}")
    void deleteMessageByMessageId(@Param("messageId") int messageId);

    @Select("SELECT UserId from messageboard where MessageId =#{messageId}")
    int getUserIdByMessageId(@Param("messageId") int messageId);

    @Select("SELECT * FROM article WHERE AuthorID =#{UserId}")
    List<Article> findArticlesByUserId(@Param("UserId") int UserId);

    @Update("UPDATE article SET Title = #{title},Content = #{content}, CreateTime = #{createTime} WHERE ArticleId = #{ArticleId}")
    void UpdateArticleByArticleId(@Param("title")String title,@Param("content")
    String content,@Param("createTime")String createTime,@Param("ArticleId")int ArticleId);

    @Delete("Delete  FROM favoritesarticle where ArticleId = #{ArticleId} and UserId =#{UserId}")
    void deleteFavorArticleByFavorId(@Param("ArticleId") int ArticleId,@Param("UserId") int UserId);

    @Select("SELECT * FROM article LIMIT #{offset}, #{limit}")
    List<Article> getArticlesByPage(@Param("offset")int offset, @Param("limit")int limit);

    @Select("SELECT COUNT(*) FROM article")
    int getTotalArticleCount();

    @Select("SELECT * FROM temparticle where UserId = #{userId}")
    Article getAllFromTempArticleByUserId(@Param("userId")int userId);

    @Insert("INSERT into temparticle(UserId, Title,Content) VALUES (#{UserId},#{Title},#{Content})")
    void addTempArticle(@Param("UserId")int UserId,@Param("Title")String Title,@Param("Content")String Content);

    @Update("UPDATE temparticle SET Title = #{Title}, Content = #{Content} WHERE UserId = #{UserId}")
    void updateTempArticle(@Param("UserId") int UserId, @Param("Title") String Title, @Param("Content") String Content);

    @Select("SELECT COUNT(*) FROM temparticle WHERE UserId = #{UserId}")
    int checkTempArticleExist(@Param("UserId") int UserId);

    @Delete("DELETE FROM temparticle WHERE UserId = #{UserId}")
    void deleteTempArticle(@Param("UserId") int UserId);



}
