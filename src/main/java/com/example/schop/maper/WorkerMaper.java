package com.example.schop.maper;

import com.example.schop.dto.WorkerDto;
import com.example.schop.entity.Worker;

import java.util.List;

public class WorkerMaper {
    public static Worker toWorker(WorkerDto workerDto){
        return Worker.builder()
                .age(workerDto.age())
                .firstName(workerDto.firstName())
                .lastName(workerDto.lastName())
                .build();
    }
    public static WorkerDto toWorkerDto(Worker worker){
        return WorkerDto.builder()
                .id(worker.getId())
                .age(worker.getAge())
                .firstName(worker.getFirstName())
                .lastName(worker.getLastName())
                .build();
    }

    public static List<Worker> toListWorker(List<WorkerDto> workerDtoList){
        return workerDtoList.stream()
                .map(WorkerMaper::toWorker)
                .toList();
    }
    public static List<WorkerDto> toListWorkerDto(List<Worker> workerList){
        return workerList.stream()
                .map(WorkerMaper::toWorkerDto)
                .toList();
    }
}
