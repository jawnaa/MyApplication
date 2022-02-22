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
    private String address;
    private AccessoriesCat category;
    private ShoesCat category;
    private BagsCat category;
    private ClothesCat category;
    private DecorCat category;
    private String photo;
    private String phone;
    private AccessoriesCat Accessories;
    private ShoesCat Shoes;
    private BagsCat Bags;
    private ClothesCat Clothes;
    private DecorCat Decor;
    private String photos;
    private String size;
    private String color;
    private String Price;
    private boolean Gender;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", category=" + category +
                ", category=" + category +
                ", category=" + category +
                ", category=" + category +
                ", category=" + category +
                ", photo='" + photo + '\'' +
                ", phone='" + phone + '\'' +
                ", Accessories=" + Accessories +
                ", Shoes=" + Shoes +
                ", Bags=" + Bags +
                ", Clothes=" + Clothes +
                ", Decor=" + Decor +
                ", photos='" + photos + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", Price='" + Price + '\'' +
                ", Gender=" + Gender +
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AccessoriesCat getAccessories() {
        return Accessories;
    }

    public void setAccessories(AccessoriesCat accessories) {
        Accessories = accessories;
    }

    public ShoesCat getShoes() {
        return Shoes;
    }

    public void setShoes(ShoesCat shoes) {
        Shoes = shoes;
    }

    public BagsCat getBags() {
        return Bags;
    }

    public void setBags(BagsCat bags) {
        Bags = bags;
    }

    public ClothesCat getClothes() {
        return Clothes;
    }

    public void setClothes(ClothesCat clothes) {
        Clothes = clothes;
    }

    public DecorCat getDecor() {
        return Decor;
    }

    public void setDecor(DecorCat decor) {
        Decor = decor;
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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
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
}

