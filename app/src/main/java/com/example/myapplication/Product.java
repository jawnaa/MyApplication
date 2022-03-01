package com.example.myapplication;
import java.io.Serializable;
enum AccessoriesCat
{
    scarf,ring,earrings,bracelet,necklace
}

enum ShoesCat
{
    Sandals , flipflop, sneakers
}
enum BagsCat
{
    backpack, laptopbag, wallet
}

enum ClothesCat
{
    dress, tshirt, pants, socks
}

enum DecorCat
{
    decoration, blankets, tables, mirror
}

public class Product implements Serializable {
    private String name;
    private String description;
    private String color;
    private AccessoriesCat category;
    private ShoesCat category;
    private BagsCat category;
    private ClothesCat category;
    private DecorCat category;
    private String photo;
    private String size;
    private String price;
    private boolean Gender;


    public Product(){
    }



public  Product  ( String name,String description, String color,AccessoriesCat category,
                   ShoesCat category,BagsCat category,ClothesCat category,DecorCat category,String photo,
                   String size,String price,boolean Gender) {
    this.name = name;
    this.description = description;
    this.color = color;
    this.category = category;
    this.photo = photo;
    this.size = size;
    this.price = price;
    this.Gender = Gender;
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

    public AccessoriesCat getCategory() {
        return category;
    }

    public void setCategory(DecorCat category) {
        this.category = category;
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
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    public void setCategory(ClothesCat category) {
        this.category = category;
    }

    public void setCategory(BagsCat category) {
        this.category = category;
    }

    public void setCategory(ShoesCat category) {
        this.category = category;
    }

    public void setCategory(AccessoriesCat category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", category=" + category +
                ", category=" + category +
                ", category=" + category +
                ", category=" + category +
                ", category=" + category +
                ", photo='" + photo + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", Gender=" + Gender +
                '}';
    }}
