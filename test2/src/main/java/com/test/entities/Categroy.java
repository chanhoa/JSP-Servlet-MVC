package com.test.entities;



public class Categroy {

    int id;
    String categoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Categroy() {
    }

    public Categroy(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
}
