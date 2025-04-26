package edu.MosBurgers.service;

import edu.MosBurgers.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customer);

    List<CustomerDTO> getAllCustomers();

    Optional<CustomerDTO> getCustomerById(Long id);

    CustomerDTO updateCustomer(Long id, CustomerDTO customer);

    void deleteCustomer(Long id);
}
