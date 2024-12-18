package org.entity;

import lombok.Data;

@Data
public class Message {
    public int MessageId;
    public String Content;
    public String UserId;
    public String ArticleId;
    public String CreatTime;
}
