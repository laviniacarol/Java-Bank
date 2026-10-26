package com.laviniacarol.javabank.service;

import com.laviniacarol.javabank.dto.CreateCustomerRequest;
import com.laviniacarol.javabank.dto.CustomerResponse;
import com.laviniacarol.javabank.entity.Customer;
import com.laviniacarol.javabank.exception.ConflictException;
import com.laviniacarol.javabank.exception.ResourceNotFoundException;
import com.laviniacarol.javabank.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public CustomerResponse create(CreateCustomerRequest request) {
        String email = request.email().trim().toLowerCase();

        if (customerRepository.existsByCpf(request.cpf())) {
            throw new ConflictException("Já existe um cliente com esse CPF");
        }
        if (customerRepository.existsByEmail(email)) {
            throw new ConflictException("Já existe um cliente com esse e-mail");
        }

        Customer customer = new Customer(request.name().trim(), request.cpf(), email);
        Customer saved = customerRepository.save(customer);
        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public CustomerResponse findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return toResponse(customer);
    }

    private CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getCpf(),
                customer.getEmail(),
                customer.getCreatedAt());
    }
}