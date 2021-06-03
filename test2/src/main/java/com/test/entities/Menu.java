package com.test.entities;


public class Menu {
    int id;
    String name;
    String image;
    int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Menu() {
    }

    public Menu(int id, String name, String image, int categoryId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.categoryId = categoryId;
    }
}
