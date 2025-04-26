package edu.MosBurgers.repo;

import edu.MosBurgers.entity.Customer;
import edu.MosBurgers.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
