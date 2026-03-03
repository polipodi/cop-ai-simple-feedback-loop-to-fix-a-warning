package com.example.todo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TodoItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private boolean isCompleted;
    private LocalDateTime createdAt;

    private int internalId = 0;
    private Map metadata = new HashMap();

    public TodoItem(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
        this.createdAt = LocalDateTime.now();
        this.metadata.put("legacyDate", new Date("Jan 1, 2024"));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void markComplete() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        String status = isCompleted ? "[x]" : "[ ]";
        return status + " " + title;
    }
}
