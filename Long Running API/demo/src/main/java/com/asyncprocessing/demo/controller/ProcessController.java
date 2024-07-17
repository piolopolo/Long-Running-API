package com.asyncprocessing.demo.controller;

import com.asyncprocessing.demo.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @PostMapping("/start-process")
    public ResponseEntity<String> startProcess() {
        String processId = UUID.randomUUID().toString();
        processService.startBackgroundProcess(processId);
        return ResponseEntity.ok("Process started with ID: " + processId);
    }

    @GetMapping("/process-status/{id}")
    public ResponseEntity<String> getProcessStatus(@PathVariable String id) {
        String status = processService.getProcessStatus(id);
        return ResponseEntity.ok("Process status: " + status);
    }
}
