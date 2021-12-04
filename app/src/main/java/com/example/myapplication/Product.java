package com.example.myapplication;

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


public class Product {
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

    public Product(AccessoriesCat accessories, ShoesCat shoes, BagsCat bags, ClothesCat clothes, DecorCat decor, String photos, String size, String color, String price, boolean gender) {
        Accessories = accessories;
        Shoes = shoes;
        Bags = bags;
        Clothes = clothes;
        Decor = decor;
        this.photos = photos;
        this.size = size;
        this.color = color;
        Price = price;
        Gender = gender;
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

    @Override
    public String toString() {
        return "Product{" +
                "Accessories=" + Accessories +
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
}

