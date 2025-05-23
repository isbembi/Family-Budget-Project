package model;

import java.util.Date;

public class FamilyChat {
    private String userName;
    private String message;
    private Date createdAt;

    public FamilyChat(String userName, Date createdAt) {
        this.userName = userName;
        this.message = message;
        this.createdAt = createdAt;
    }

    public String getUserName() { return userName; }
    public String getMessage() { return message; }
    public Date getCreatedAt() { return createdAt; }

    public void setUserName(String userName) { this.userName = userName; }
    public void setMessage(String message) { this.message = message; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
