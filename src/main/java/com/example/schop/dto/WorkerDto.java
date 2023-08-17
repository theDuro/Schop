package com.example.schop.dto;

import lombok.Builder;


@Builder
public record WorkerDto(Long id
        ,String firstName
        ,String lastName
        ,int age) {
    @Override
    public String toString() {
        return "WorkerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
