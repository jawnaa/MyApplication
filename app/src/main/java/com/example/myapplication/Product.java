package com.example.myapplication;
import java.io.Serializable;


public class Product implements Serializable {
    private String name;
    private String description;
    private String color;
    private AccessoriesCat categoryAcc;
    private ShoesCat categorySho;
    private BagsCat categoryBag;
    private ClothesCat categoryClo;
    private DecorCat categoryDec;
    private String photo;
    private String size;
    private String price;
    private boolean gender;

    public Product(String name, String description, String color, AccessoriesCat valueOf, ShoesCat valueOf1, BagsCat valueOf2, ClothesCat valueOf3, DecorCat valueOf4, String photo, String size, String price, boolean gender) {
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", categoryAcc=" + categoryAcc +
                ", categorySho=" + categorySho +
                ", categoryBag=" + categoryBag +
                ", categoryClo=" + categoryClo +
                ", categoryDec=" + categoryDec +
                ", photo='" + photo + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", gender=" + gender +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AccessoriesCat getCategoryAcc() {
        return categoryAcc;
    }

    public void setCategoryAcc(AccessoriesCat categoryAcc) {
        this.categoryAcc = categoryAcc;
    }

    public ShoesCat getCategorySho() {
        return categorySho;
    }

    public void setCategorySho(ShoesCat categorySho) {
        this.categorySho = categorySho;
    }

    public BagsCat getCategoryBag() {
        return categoryBag;
    }

    public void setCategoryBag(BagsCat categoryBag) {
        this.categoryBag = categoryBag;
    }

    public ClothesCat getCategoryClo() {
        return categoryClo;
    }

    public void setCategoryClo(ClothesCat categoryClo) {
        this.categoryClo = categoryClo;
    }

    public DecorCat getCategoryDec() {
        return categoryDec;
    }

    public void setCategoryDec(DecorCat categoryDec) {
        this.categoryDec = categoryDec;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }}






