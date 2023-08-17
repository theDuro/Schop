package com.example.schop.service;

import com.example.schop.dto.ProductDto;
import com.example.schop.dto.WorkerDto;
import com.example.schop.entity.Product;
import com.example.schop.entity.Worker;
import com.example.schop.maper.ProductMapeer;
import com.example.schop.maper.WorkerMaper;
import com.example.schop.operations.ProductComparator;
import com.example.schop.operations.WorkerComaprator;
import com.example.schop.repository.ProductRepository;
import com.example.schop.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ShopService {
    private final WorkerRepository workerRepository;
    private final ProductRepository productRepository;
    private final ProductComparator productComparator;
    private final WorkerComaprator workerComaprator;

    @Autowired
    public ShopService(WorkerRepository workerRepository
            , ProductRepository productRepository
            , ProductComparator productComparator
            , WorkerComaprator workerComaprator
    ) {
        this.workerRepository = workerRepository;
        this.productRepository = productRepository;
        this.productComparator = productComparator;
        this.workerComaprator = workerComaprator;
    }


    public List<ProductDto> getProduct() {
        List<Product> productList = productRepository.findAll();
        return ProductMapeer.toListProductDto(productList);
    }
    public List<ProductDto> getProducts(int page, int size, String sortField, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.map(ProductMapeer::toProductDto).getContent();
    }

    public List<ProductDto> getSortedProduct() {
        List<ProductDto> productDtos = new ArrayList<>(getProduct());
        productDtos.sort(productComparator);
        return productDtos;
    }

    public Product addProduct(ProductDto productDto) {
        Product product = ProductMapeer.toProduct(productDto);
        return productRepository.save(product);
    }

    public Product updateProduct(ProductDto productDto) {
        Product product = ProductMapeer.toProduct(productDto);
        product.setId(productDto.id());
        return productRepository.save(product);
    }

    public void delteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductDto> getProductsByName(String name) {
        List<Product> produtsByName = productRepository.findByName(name);
        return ProductMapeer.toListProductDto(produtsByName);
    }

    public List<ProductDto> getProductsBySoldStatatus(boolean status) {
        List<Product> productBySodetStatus = productRepository.getBYSold(status);
        return ProductMapeer.toListProductDto(productBySodetStatus);
    }

    ///Workers
    public List<WorkerDto> getWorkers() {
        List<Worker> workerList = workerRepository.findAll();
        return WorkerMaper.toListWorkerDto(workerList);
    }
    public List<WorkerDto> getWorkers(int page, int size, String sortField, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Worker> productPage = workerRepository.findAll(pageable);
        return productPage.map(WorkerMaper::toWorkerDto).getContent();
    }

    public List<WorkerDto> getSortedWorked() {
        List<WorkerDto> workerList = new ArrayList<>(getWorkers());
        workerList.sort(workerComaprator);
        return workerList;
    }


    public Worker addWorker(WorkerDto workerDto) {
        Worker worker = WorkerMaper.toWorker(workerDto);
        return workerRepository.save(worker);
    }

    public Worker updateWorker(WorkerDto workerDto) {
        Worker worker = WorkerMaper.toWorker(workerDto);
        worker.setId(workerDto.id());
        return workerRepository.save(worker);
    }

    public void detleWorker(Long id) {
        workerRepository.deleteById(id);
    }

    public List<WorkerDto> getWorkersByAge(int age) {
        List<Worker> workers = workerRepository.findByAge(age);
        return WorkerMaper.toListWorkerDto(workers);
    }
    public List<?> getSombtingByFlag(boolean flag){
        if (flag) {
            return getProduct();
        } else {
            return getWorkers();
        }
    }

}
