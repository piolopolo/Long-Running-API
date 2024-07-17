package com.asyncprocessing.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class ProcessService {

    private final ConcurrentHashMap<String, String> processStatus = new ConcurrentHashMap<>();
    private final Executor executor = Executors.newCachedThreadPool();

    @Async
    public void startBackgroundProcess(String processId) {
        processStatus.put(processId, "In Progress");
        executor.execute(() -> {
            try {
                // Simulasi proses yang memakan waktu lama
                TimeUnit.MINUTES.sleep(5);
                processStatus.put(processId, "Completed");
            } catch (InterruptedException e) {
                processStatus.put(processId, "Failed");
            }
        });
    }

    public String getProcessStatus(String processId) {
        return processStatus.getOrDefault(processId, "Unknown Process ID");
    }
}
