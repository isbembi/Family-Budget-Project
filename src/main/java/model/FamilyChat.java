package model;

import java.util.Date;

public class FamilyChat {
    private int id;
    private int userId;
    private String message;
    private Date createdAt;

    public FamilyChat(int id, int userId, String message, Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getMessage() { return message; }
    public Date getCreatedAt() { return createdAt; }
}
