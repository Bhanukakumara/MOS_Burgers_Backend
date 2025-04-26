package edu.MosBurgers.service.impl;

import edu.MosBurgers.dto.CustomerDTO;
import edu.MosBurgers.service.CustomerService;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(Long id) {
        return Optional.empty();
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
