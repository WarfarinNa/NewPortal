package org.entity;

import lombok.Data;

@Data
public class FavoritesArticle {
    public int FavoriteId;
    public int UserId;
    public int ArticleId;
    public String CreateTime;
}
