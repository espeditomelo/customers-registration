package me.app.customers.service.impl;

import me.app.customers.domain.model.Address;
import me.app.customers.domain.model.Customer;
import me.app.customers.domain.repository.AddressRepository;
import me.app.customers.domain.repository.CustomerRepository;
import me.app.customers.domain.repository.OccupationRepository;
import me.app.customers.service.CustomerService;
import me.app.customers.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OccupationRepository occupationRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customerFinded = customerRepository.findById(id);
        return customerFinded.get();
    }

    @Override
    public Customer create(Customer customer) {
         String cep = customer.getAddress().getCep();
         Address address = findAddressByCep(cep);
         customer.setAddress(address);
       return customerRepository.save(customer);
    }

    @Override
    public void update(Long id, Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()){
            customerRepository.save(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        customerOptional.ifPresent(customer -> customerRepository.delete(customer));
    }

    public Address findAddressByCep(String cep){
        Address address = addressRepository.findById(cep).orElseGet( () -> {
            Address newAddress = viaCepService.getCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        return address;
    }
}
