package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.basket.BasketDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodDto;
import com.itbrains.restaurantspringboot.dtos.user.UserDto;
import com.itbrains.restaurantspringboot.helpers.Calculator;
import com.itbrains.restaurantspringboot.models.Basket;
import com.itbrains.restaurantspringboot.models.Food;
import com.itbrains.restaurantspringboot.models.UserEntity;
import com.itbrains.restaurantspringboot.repos.BasketRepository;
import com.itbrains.restaurantspringboot.repos.UserEntityRepository;
import com.itbrains.restaurantspringboot.services.BasketService;
import com.itbrains.restaurantspringboot.services.FoodService;
import com.itbrains.restaurantspringboot.services.UserEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private UserEntityService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FoodService foodService;


    @Override
    public void add(Long foodId, String userEmail) {
        UserEntity userEntity = userService.findRealUserByEmail(userEmail);
        Basket findBasket= userEntity.getBasket();
        if(findBasket==null){
            Basket newBasket = new Basket();
            newBasket.setUser(userEntity);
            basketRepository.save(newBasket);
            userEntity.setBasket(newBasket);
            userEntityRepository.save(userEntity);
        }
        else {
        Food food = foodService.getRealFoodById(foodId);
        List<Food> foods = findBasket.getFoods();
        foods.add(food);
        findBasket.setFoods(foods);
        double totalPrice = Calculator.calculator(findBasket.getFoods());
        findBasket.setTotalPrice(totalPrice);
        basketRepository.save(findBasket);
        }
    }

    @Override
    public BasketDto getBasketByUserEmail(String userEmail) {
       UserEntity user= userService.findRealUserByEmail(userEmail);
        Basket findBasket= user.getBasket();
        return modelMapper.map(findBasket, BasketDto.class);
    }

    @Override
    @Transactional
    public void remove(Long foodId, String userEmail) {
        UserEntity userEntity = userService.findRealUserByEmail(userEmail);
        basketRepository.removeFoodFromBasket(userEntity.getBasket().getId(),foodId);
        Basket findBasket= basketRepository.findById(userEntity.getBasket().getId()).orElseThrow();
//        Food inFood = foodService.getRealFoodById(foodId);
//        List<Food> foods = findBasket.getFoods();
//        foods.remove(inFood);
//        findBasket.setFoods(foods);   /// kinda sus
        double totalPrice = Calculator.calculator(findBasket.getFoods());
        findBasket.setTotalPrice(totalPrice);
        basketRepository.save(findBasket);

    }

}
