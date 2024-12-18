package org.entity;

import lombok.Data;

@Data
public class User {
    public int UserId;
    public String UserName;
    public String PassWord;
    public String Sex;
    public String Role;
    public String Signature;
}
