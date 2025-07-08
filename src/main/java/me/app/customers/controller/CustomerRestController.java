package me.app.customers.controller;

import me.app.customers.domain.model.Customer;
import me.app.customers.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerRestController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        customerService.remove(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customerToUpdate){
        customerService.update(id, customerToUpdate);
        return ResponseEntity.ok(customerToUpdate);
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customerToSave){
        customerService.create(customerToSave);
        return ResponseEntity.ok(customerToSave);
    }
}

