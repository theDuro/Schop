package com.example.schop.repository;

import com.example.schop.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {
 List<Worker> findByAge(int age);
}
