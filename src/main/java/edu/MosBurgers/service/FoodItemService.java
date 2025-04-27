package edu.MosBurgers.service;

import edu.MosBurgers.dto.FoodItemDTO;
import edu.MosBurgers.entity.FoodItem;

import java.util.List;
import java.util.Optional;

public interface FoodItemService {
    FoodItem addFoodItem(FoodItemDTO foodItem);
    List<FoodItem> getAllFoodItems();
    Optional<FoodItem> getFoodItemById(Integer id);
    FoodItem updateFoodItem(Integer id, FoodItemDTO foodItem);
    void deleteFoodItem(Integer id);
    List<FoodItem> getExpiredFoodItems();
    void removeExpiredFoodItems();
    List<FoodItem> searchFoodItems(String searchQuery);
}
