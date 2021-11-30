package com.example.myapplication;

enum Accessories
{
    scarf,ring,earrings,bracelet,necklace
}

enum Shoes
{
    Sandals , flipflop, sneakers
}
enum Bags
{
    backpack, laptopbag, wallet
}

enum Clothes
{
    dress, tshirt, pants, socks
}
enum Decor
{
    decoration, blankets, tables, mirror
}


public class Product
{
    private Accessories Accessories;
    private Shoes Shoes;
    private Bags Bags;
    private Clothes Clothes;
    private Product Decor;
    private Decor name;
    private int phonenumber;
    private int id;
    private String photos;
    private String size;
    private String color;
    private  int visanumber;
    private boolean gender;

    public com.example.myapplication.Accessories getAccessories() {
        return Accessories;
    }

    public void setAccessories(com.example.myapplication.Accessories accessories) {
        Accessories = accessories;
    }

    public com.example.myapplication.Shoes getShoes() {
        return Shoes;
    }

    public void setShoes(com.example.myapplication.Shoes shoes) {
        Shoes = shoes;
    }

    public com.example.myapplication.Bags getBags() {
        return Bags;
    }

    public void setBags(com.example.myapplication.Bags bags) {
        Bags = bags;
    }

    public com.example.myapplication.Clothes getClothes() {
        return Clothes;
    }

    public void setClothes(com.example.myapplication.Clothes clothes) {
        Clothes = clothes;
    }

    public Product getDecor() {
        return Decor;
    }

    public void setDecor(Product decor) {
        Decor = decor;
    }

    public com.example.myapplication.Decor getName() {
        return name;
    }

    public void setName(com.example.myapplication.Decor name) {
        this.name = name;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVisanumber() {
        return visanumber;
    }

    public void setVisanumber(int visanumber) {
        this.visanumber = visanumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Accessories=" + Accessories +
                ", Shoes=" + Shoes +
                ", Bags=" + Bags +
                ", Clothes=" + Clothes +
                ", Decor=" + Decor +
                ", name=" + name +
                ", phonenumber=" + phonenumber +
                ", id=" + id +
                ", photos='" + photos + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", visanumber=" + visanumber +
                ", gender=" + gender +
                '}';
    }
}
