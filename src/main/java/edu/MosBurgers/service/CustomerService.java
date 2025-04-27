package edu.MosBurgers.service;

import edu.MosBurgers.dto.CustomerDTO;
import edu.MosBurgers.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer saveCustomer(CustomerDTO customer);

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Integer id);

    Customer updateCustomer(Integer id, CustomerDTO customer);

    void deleteCustomer(Integer id);
}
