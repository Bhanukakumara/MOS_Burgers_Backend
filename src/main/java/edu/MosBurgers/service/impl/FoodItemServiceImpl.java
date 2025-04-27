package edu.MosBurgers.service.impl;

import edu.MosBurgers.dto.FoodItemDTO;
import edu.MosBurgers.entity.FoodItem;
import edu.MosBurgers.repo.FoodItemRepository;
import edu.MosBurgers.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {

    final FoodItemRepository foodItemRepository;
    final ModelMapper modelMapper;
    
    @Override
    public FoodItem addFoodItem(FoodItemDTO foodItem) {
        return foodItemRepository.save(modelMapper.map(foodItem, FoodItem.class));
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    @Override
    public Optional<FoodItem> getFoodItemById(Integer id) {
        return foodItemRepository.findById(id);
    }

    @Override
    public FoodItem updateFoodItem(Integer id, FoodItemDTO foodItem) {
        Optional<FoodItem> existingFoodItemOpt = foodItemRepository.findById(id);
        if (existingFoodItemOpt.isPresent()) {
            FoodItem existingFoodItem = existingFoodItemOpt.get();
            modelMapper.map(foodItem, existingFoodItem);
            return foodItemRepository.save(existingFoodItem);
        } else {
            throw new RuntimeException("Food item not found with ID: " + id);
        }
    }

    @Override
    public void deleteFoodItem(Integer id) {
        foodItemRepository.deleteById(id);
    }

    @Override
    public List<FoodItem> getExpiredFoodItems() {
        return foodItemRepository.findByExpirationDateBefore(new java.util.Date());
    }

    @Override
    public void removeExpiredFoodItems() {
        List<FoodItem> expiredFoodItems = getExpiredFoodItems();
        foodItemRepository.deleteAll(expiredFoodItems);
    }

    @Override
    public List<FoodItem> searchFoodItems(String searchQuery) {
        return foodItemRepository.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(searchQuery, searchQuery);
    }
}
