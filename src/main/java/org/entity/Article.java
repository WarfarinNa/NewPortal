package org.entity;

import lombok.Data;

@Data
public class Article {
    public int ArticleId;
    public String Title;
    public String Content;
    public String AuthorId;
    public String CreateTime;
}
