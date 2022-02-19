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
    private String photos1;
    private String photos2;
    private String photos3;
    private String size;
    private String color;
    private String Price;
    private String Name;
    private String Description;
    private boolean Gender;

    @Override
    public String toString() {
        return "Product{" +
                "Accessories=" + Accessories +
                ", Shoes=" + Shoes +
                ", Bags=" + Bags +
                ", Clothes=" + Clothes +
                ", Decor=" + Decor +
                ", photos1='" + photos1 + '\'' +
                ", photos2='" + photos2 + '\'' +
                ", photos3='" + photos3 + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", Price='" + Price + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Gender=" + Gender +
                '}';
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

    public String getPhotos1() {
        return photos1;
    }

    public void setPhotos1(String photos1) {
        this.photos1 = photos1;
    }

    public String getPhotos2() {
        return photos2;
    }

    public void setPhotos2(String photos2) {
        this.photos2 = photos2;
    }

    public String getPhotos3() {
        return photos3;
    }

    public void setPhotos3(String photos3) {
        this.photos3 = photos3;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }
}



















