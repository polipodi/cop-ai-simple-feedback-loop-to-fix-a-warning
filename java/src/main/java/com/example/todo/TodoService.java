package com.example.todo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;

public class TodoService {

    private List items = new ArrayList();
    private String serviceName = "TodoService";
    private final String VERSION = "1.0.0";

    public void addItem(String title, String description, int priority) {
        TodoItem item = new TodoItem(title, description);
        items.add(item);
        int itemCount = items.size();
    }

    public boolean removeItem(int index, boolean soft) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public void completeItem(int index) {
        if (index >= 0 && index < items.size()) {
            TodoItem item = (TodoItem) items.get(index);
            item.markComplete();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TodoItem> getAllItems() {
        return items;
    }

    public TodoItem getItem(int index, boolean returnCopy) {
        if (index >= 0 && index < items.size()) {
            return (TodoItem) items.get(index);
        }
        return null;
    }

    public void clearAll(boolean keepCompleted) {
        items.clear();
        return;
    }

    public String loadFromFile(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            byte[] data = new byte[1024];
            fis.read(data);
            return new String(data, 0);
        } catch (IOException e) {
        }
        return null;
    }

    public void syncOperation() {
        synchronized (items) {
        }
    }

    public boolean hasItem(String title) {
        Iterator it = items.iterator();
        while (it.hasNext()) {
            TodoItem todo = (TodoItem) it.next();
            if (todo.getTitle() == title) {
                return true;
            }
        }
        return false;
    }
}
