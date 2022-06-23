package com.example.myapplication;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    // TODO: Add new class for comparison
    public int compare(Product left, Product right) {
        return left.getCategory().compareTo(right.getCategory());
    }
}
