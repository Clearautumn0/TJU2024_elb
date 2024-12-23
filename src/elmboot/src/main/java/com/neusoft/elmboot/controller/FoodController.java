package com.neusoft.elmboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.po.Food;
import com.neusoft.elmboot.service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodController {
	
	@Autowired
	private FoodService foodService;

	//@RequestMapping("/listFoodByBusinessId")
	@GetMapping("/business/{businessId}")
	public List<Food> listFoodByBusinessId(@PathVariable Integer businessId) throws Exception{
		return foodService.listFoodByBusinessId(businessId);
	}
	
	@GetMapping("/{foodId}")
	public Food getFoodById(@PathVariable Integer foodId) throws Exception{
		return foodService.getFoodById(foodId);
	}
	
	@PostMapping
	public Map<String, Integer> addFood(@RequestBody Food food) {
		Map<String, Integer> response = new HashMap<>();
		response.put("data", foodService.addFood(food));
		return response;
	}
	
	@PutMapping
	public Map<String, Integer> updateFood(@RequestBody Food food) {
		Map<String, Integer> response = new HashMap<>();
		response.put("data", foodService.updateFood(food));
		return response;
	}
	
	@PatchMapping
	public Integer setFood(@RequestBody Food food) {
		return foodService.setFood(food);
	}
	
	@DeleteMapping
	public Map<String, Integer> removeFood(@RequestParam Integer businessId, @RequestParam Integer foodId) {
		Map<String, Integer> response = new HashMap<>();
		response.put("data", foodService.removeFood(businessId, foodId));
		return response;
	}
}
