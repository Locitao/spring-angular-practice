package com.practice.backend.model;

public class Todo {

    private String nameOfPerson;
    private String title;
    private int importance;
    private boolean status = false;

    public Todo() {}

    public Todo(String nameOfPerson, String title, int importance) {
        this.nameOfPerson = nameOfPerson;
        this.title = title;
        this.importance = importance;
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "nameOfPerson='" + nameOfPerson + '\'' +
                ", title='" + title + '\'' +
                ", importance=" + importance +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        if (importance != todo.importance) return false;
        if (nameOfPerson != null ? !nameOfPerson.equals(todo.nameOfPerson) : todo.nameOfPerson != null) return false;
        return title != null ? title.equals(todo.title) : todo.title == null;
    }

    @Override
    public int hashCode() {
        int result = nameOfPerson != null ? nameOfPerson.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + importance;
        return result;
    }
}
