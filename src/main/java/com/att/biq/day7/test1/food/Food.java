package com.att.biq.day7.test1.food;

import java.util.Map;
import java.util.Map.Entry;

public class Food
{

	private String name;
	private int caloriesPer100Gram = 100;
	private int fat = 1;
	private int protein = 2;
	private int sodium = 3;
	private int carbohydrates = 4;

	private float totalCalories = 0;
	private float totalProtein = 0;
	private float totalSodium = 0;
	private float totalFat = 0;
	private float totalCarbohydrates = 0;

	public int total = 0;

	public Food(String name, int fat, int protein, int sodium, int carbohydrates)
	{
		this.name = name;
		this.fat = fat;
		this.protein = protein;
		this.sodium = sodium;
		this.carbohydrates = carbohydrates;

	}

	public Food(String name, int amount)
	{
		this.name = name;
		setTotalCalories(amount);
		setTotalCarbohydrates(amount);
		setTotalSodium(amount);
		setTotalFat(amount);
	}

	public void setTotalCalories(int gram)
	{
		totalCalories = (caloriesPer100Gram / 100) * gram;
	}

	public void setTotalCarbohydrates(int gram)
	{
		float percent = (float) carbohydrates / gram * 100;
		totalCarbohydrates = gram * percent;
	}

	public void setTotalFat(int gram)
	{
		float percent = (float) carbohydrates / gram * 100;
		totalFat = gram * percent;
	}

	public void setTotalSodium(int gram)
	{
		float percent = (float) carbohydrates / gram * 100;
		totalSodium = gram * percent;
	}

	public void setTotalProtein(int gram)
	{
		float percent = (float) carbohydrates / gram * 100;
		totalProtein = gram * percent;
	}

	public static void calcTotal(Map<Food, Integer> foods)
	{
		Food totaFood = new Food("Total",0);
		for (Entry<Food, Integer> entry : foods.entrySet())
		{
			Food food = entry.getKey();
			totaFood.setTotalCalories(totaFood.getTotalCalories() + food.getTotalCalories());
			totaFood.setTotalCalories(totaFood.getTotalCarbohydrates() + food.getTotalCarbohydrates());
			totaFood.setTotalCalories(totaFood.getTotalProtein() + food.getTotalProtein());
			totaFood.setTotalCalories(totaFood.getTotalSodium() + food.getTotalSodium());
			totaFood.setTotalCalories(totaFood.getTotalFat() + food.getTotalFat());
		}
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getCaloriesPer100Gram()
	{
		return caloriesPer100Gram;
	}

	public int getFat()
	{
		return fat;
	}

	public void setFat(int fat)
	{
		this.fat = fat;
	}

	public int getProtein()
	{
		return protein;
	}

	public void setProtein(int protein)
	{
		this.protein = protein;
	}

	public int getSodium()
	{
		return sodium;
	}

	public void setSodium(int sodium)
	{
		this.sodium = sodium;
	}

	public int getCarbohydrates()
	{
		return carbohydrates;
	}

	public float getTotalCalories()
	{
		return totalCalories;
	}

	public void setTotalCalories(float totalCalories)
	{
		this.totalCalories = totalCalories;
	}

	public float getTotalProtein()
	{
		return totalProtein;
	}

	public void setTotalProtein(float totalProtein)
	{
		this.totalProtein = totalProtein;
	}

	public float getTotalSodium()
	{
		return totalSodium;
	}

	public void setTotalSodium(float totalSodium)
	{
		this.totalSodium = totalSodium;
	}

	public float getTotalFat()
	{
		return totalFat;
	}

	public void setTotalFat(float totalFat)
	{
		this.totalFat = totalFat;
	}

	public float getTotalCarbohydrates()
	{
		return totalCarbohydrates;
	}

	public void setTotalCarbohydrates(float totalCarbohydrates)
	{
		this.totalCarbohydrates = totalCarbohydrates;
	}
}
