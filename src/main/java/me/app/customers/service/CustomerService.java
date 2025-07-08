package me.app.customers.service;

import me.app.customers.domain.model.Customer;

public interface CustomerService {

    public Iterable<Customer> getAll();

    public Customer findById(Long id);

    public Customer create(Customer customer);

    public void update(Long id, Customer customer);

    public void remove(Long id);
}
