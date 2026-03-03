package com.example.todo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

public class TodoItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private boolean isCompleted;
    private LocalDateTime createdAt;

    private transient int internalId = 0;
    private HashMap<String, Serializable> metadata = new HashMap<>();

    public TodoItem(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
        this.createdAt = LocalDateTime.now();
        Date legacyDate = Date.from(
                LocalDate.of(2024, 1, 1)
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()
        );
        this.metadata.put("legacyDate", legacyDate);
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
