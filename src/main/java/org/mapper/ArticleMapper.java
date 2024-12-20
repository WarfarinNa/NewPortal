package org.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    @Insert("INSERT into favoritesarticle(UserId, ArticleId, CreateTime) VALUES (#{UserId},#{ArticleId},#{CreateTime})")
    Boolean AddFavorArticle(@Param("UserId")int UserId,@Param("ArticleId")int ArticleId,@Param("CreateTime")String CreateTime);

    @Select("SELECT * from favoritesarticle where UserId = #{UserId}")
    List<Article> getAllFavorArticleByUserId(@Param("UserId")int UserId);

    @Select("SELECT * from messageboard where ArticleId = #{ArticleId}")
    List<Message> getAllMessageByArticleId(@Param("ArticleId")int ArticleId);

    @Insert("INSERT into messageboard(Content, UserId,ArticleId,CreatTime) " +
            "VALUES (#{Content},#{UserId},#{ArticleId},#{CreatTime})")
    Boolean addMessageByUserId(@Param("Content")String Content,
                               @Param("UserId")int UserId,@Param("ArticleId")int ArticleId,@Param("CreatTime")String CreatTime);




}
