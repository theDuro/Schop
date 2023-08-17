package com.example.schop.contlorel;

import com.example.schop.dto.ProductDto;
import com.example.schop.dto.WorkerDto;
import com.example.schop.entity.Product;
import com.example.schop.entity.Worker;
import com.example.schop.service.ShopService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Log4j2
@RestController
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    // Products
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = shopService.getProduct();
        log.info("get products ");
        return ResponseEntity.ok(products);
    }
    @GetMapping("/products/params")
    public ResponseEntity<List<ProductDto>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        List<ProductDto> products = shopService.getProducts(page, size, sortField, sortDirection);
        log.info("get products with params");
        return ResponseEntity.ok(products);
    }
    @GetMapping("/products/sorted")
    public ResponseEntity<List<ProductDto>> getSortedProducts() {
        List<ProductDto> products = shopService.getSortedProduct();
        log.info("get sorted products");
        return ResponseEntity.ok(products);
    }
    @GetMapping("/products/name/{name}")
    public ResponseEntity<List<ProductDto>> getProductsByName(@PathVariable("name") String name) {
        List<ProductDto> products = shopService.getProductsByName(name);
        log.info("get product by name");
        return ResponseEntity.ok(products);
    }
    @GetMapping("/products/soled/{soled}")
    public ResponseEntity<List<ProductDto>> getProductsByStatus(@PathVariable("soled") boolean soled) {
        List<ProductDto> products = shopService.getProductsBySoldStatatus(soled);
        log.info("get products by soled value");
        return ResponseEntity.ok(products);

    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto) {
        Product product = shopService.addProduct(productDto);
        log.info("add product "+ product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto productDto) {
        Product product = shopService.updateProduct(productDto);
        log.info("update product "+ product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        shopService.delteProduct(id);
        log.info("delte product by id "+ id);
        return ResponseEntity.noContent().build();
    }

    // Workers
    @GetMapping("/workers")
    public ResponseEntity<List<WorkerDto>> getWorkers() {
        List<WorkerDto> workers = shopService.getWorkers();
        return ResponseEntity.ok(workers);
    }
    @GetMapping("workersproducts/params")
    public ResponseEntity<List<WorkerDto>> getWorkers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        List<WorkerDto> workerDtos = shopService.getWorkers(page, size, sortField, sortDirection);
        return ResponseEntity.ok(workerDtos);
    }
    @GetMapping("/workers/{flag}")
    public ResponseEntity<?>  getByFlag(@PathVariable("flag") boolean flag){
        return ResponseEntity.ok(shopService.getSombtingByFlag(flag));
    }
    @GetMapping("/workers/sorted")
    public ResponseEntity<List<WorkerDto>> getSortedWorkers() {
        List<WorkerDto> workers = shopService.getSortedWorked();
        return ResponseEntity.ok(workers);
    }
    @GetMapping("/workers/age/{age}")
    public ResponseEntity<List<WorkerDto>> getWorkersByAge(@PathVariable("age") int age) {
        List<WorkerDto> workers = shopService.getWorkersByAge(age);
        return ResponseEntity.ok(workers);
    }

    @PostMapping("/workers")
    public ResponseEntity<Worker> addWorker(@RequestBody WorkerDto workerDto) {
        Worker worker = shopService.addWorker(workerDto);
        log.info("add worker "+worker);
        return ResponseEntity.status(HttpStatus.CREATED).body(worker);
    }

    @PutMapping("/workers")
    public ResponseEntity<Worker> updateWorker(@RequestBody WorkerDto workerDto) {
        Worker worker = shopService.updateWorker(workerDto);
        log.info("update worker "+worker);
        return ResponseEntity.ok(worker);
    }

    @DeleteMapping("/workers/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
        shopService.detleWorker(id);
        log.info("delte worker by id "+id);
        return ResponseEntity.noContent().build();
    }




}
