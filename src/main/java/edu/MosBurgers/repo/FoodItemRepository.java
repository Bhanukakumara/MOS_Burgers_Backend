package edu.MosBurgers.repo;

import edu.MosBurgers.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
    List<FoodItem> findByExpirationDateBefore(Date date);

    List<FoodItem> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(String searchQuery, String searchQuery1);
}
