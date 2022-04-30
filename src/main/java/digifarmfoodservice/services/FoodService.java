package digifarmfoodservice.services;

import digifarmfoodservice.dto.FoodRequestDto;
import digifarmfoodservice.dto.FoodResponseDto;
import digifarmfoodservice.entities.User;
import java.util.List;

public interface FoodService
{
    FoodResponseDto save(FoodRequestDto foodRequestDto);

    FoodResponseDto getFood(Long id);

    FoodResponseDto update(FoodRequestDto foodRequestDto);

    List<FoodResponseDto> listFood();

    String foodOn(User user);

    String foodOff(User user);
}
