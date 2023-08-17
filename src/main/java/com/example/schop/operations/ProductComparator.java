package com.example.schop.operations;

import com.example.schop.dto.ProductDto;
import com.example.schop.entity.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<ProductDto> {
    @Override
    public int compare(ProductDto o1, ProductDto o2) {
        return o1.price().subtract(o2.price()).toBigInteger().intValue();
    }
}
