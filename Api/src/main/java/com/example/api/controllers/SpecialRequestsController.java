package com.example.api.controllers;

import com.example.api.entities.SpecialRequest;
import com.example.api.repositories.SpecialRequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/specialRequests")
@RestController
public class SpecialRequestsController {
    private final SpecialRequestsRepository repository;

    @Autowired
    public SpecialRequestsController(SpecialRequestsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<SpecialRequest> findAll() {
        return (List<SpecialRequest>) repository.findAll();
    }

    @PostMapping
    public SpecialRequest saveSpecialRequest(@RequestBody SpecialRequest request) {
        return repository.save(request);
    }

    @PutMapping("/{id}")
    public SpecialRequest updateSpecialRequest(@RequestBody SpecialRequest newRequest, @PathVariable Long id) {
        return repository.findById(id)
                .map(request -> {
                    request.setRequest(newRequest.getRequest());
                    request.setOrderId(newRequest.getOrderId());
                    return repository.save(request);
                })
                .orElseGet(() -> {
                    newRequest.setId(id);
                    return repository.save(newRequest);
                });
    }


    @DeleteMapping("/{id}")
    public void deleteSpecialRequest(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
