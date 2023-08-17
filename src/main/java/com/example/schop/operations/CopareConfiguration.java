package com.example.schop.operations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CopareConfiguration {
    @Bean
    ProductComparator productComparator(){
        return new ProductComparator();
    }

    @Bean
    WorkerComaprator worcerComaprator(){
        return new WorkerComaprator();
    }

}
