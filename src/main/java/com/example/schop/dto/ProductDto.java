package com.example.schop.dto;

import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;
@Builder
public record ProductDto( Long id
        ,String name
        ,String desription
        ,BigDecimal price
        ,boolean soled) {
    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + desription + '\'' +
                ", price=" + price +
                ", sold=" + soled +
                '}';
    }
}
