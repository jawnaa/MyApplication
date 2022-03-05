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
    private ShoesCat category1;
    private BagsCat category2;
    private ClothesCat category3;
    private DecorCat category4;
    private String photo;
    private String size;
    private String price;
    private boolean gender;

    public Product(String name, String description, String color, AccessoriesCat category,
                   ShoesCat category1, BagsCat category2, ClothesCat category3, DecorCat category4, String photo,
                   String size, String price, boolean Gender) {
        this.name = name;
        this.description = description;
        this.color = color;
        this.category = category;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.category4 = category4;
        this.photo = photo;
        this.size = size;
        this.price = price;
        this.gender = Gender;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", category=" + category +
                ", category1=" + category1 +
                ", category2=" + category2 +
                ", category3=" + category3 +
                ", category4=" + category4 +
                ", photo='" + photo + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", Gender=" + gender +
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

    public AccessoriesCat getCategory() {
        return category;
    }

    public void setCategory(AccessoriesCat category) {
        this.category = category;
    }

    public ShoesCat getCategory1() {
        return category1;
    }

    public void setCategory1(ShoesCat category1) {
        this.category1 = category1;
    }

    public BagsCat getCategory2() {
        return category2;
    }

    public void setCategory2(BagsCat category2) {
        this.category2 = category2;
    }

    public ClothesCat getCategory3() {
        return category3;
    }

    public void setCategory3(ClothesCat category3) {
        this.category3 = category3;
    }

    public DecorCat getCategory4() {
        return category4;
    }

    public void setCategory4(DecorCat category4) {
        this.category4 = category4;
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
    }

    public boolean getGender()
    {
        return this.gender;
    }


}