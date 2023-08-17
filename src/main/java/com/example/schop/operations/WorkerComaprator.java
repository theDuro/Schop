package com.example.schop.operations;

import com.example.schop.dto.WorkerDto;

import java.util.Comparator;

public class WorkerComaprator implements Comparator<WorkerDto> {
    @Override
    public int compare(WorkerDto o1, WorkerDto o2) {
        return o1.age() - o2.age();
    }
}
