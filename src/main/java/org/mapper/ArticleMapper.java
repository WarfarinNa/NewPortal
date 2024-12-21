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
}
