package org.entity;

import lombok.Data;

@Data
public class ApplicationForAdmin {
    public int ApplyId;
    public int UserId;
    public String Role;
    public String CreateTIme;
}
