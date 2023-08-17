package com.example.schop.maper;

import com.example.schop.dto.ProductDto;
import com.example.schop.entity.Product;

import java.util.List;

public class ProductMapeer {
    public static Product toProduct(ProductDto productDto){
        return Product.builder()
                .desription(productDto.desription())
                .price(productDto.price())
                .soled(productDto.soled())
                .name(productDto.name())
                .build();
    }
    public static ProductDto toProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .desription(product.getDesription())
                .name(product.getName())
                .price(product.getPrice())
                .soled(product.isSoled())
                .build();
    }
    public static List<Product> toProducyList(List<ProductDto> productDtos){
        return productDtos.stream()
                .map(ProductMapeer::toProduct)
                .toList();
    }
    public static List<ProductDto> toListProductDto(List<Product> productList){
        return productList.stream()
                .map(ProductMapeer::toProductDto)
                .toList();
    }
}
