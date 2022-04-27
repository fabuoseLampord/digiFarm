package digifarmfoodservice.services;

import digifarmfoodservice.dto.FoodRequestDto;
import digifarmfoodservice.dto.FoodResponseDto;
import java.util.List;

public interface FoodService
{
    FoodResponseDto save(FoodRequestDto foodRequestDto);

    FoodResponseDto getFood(String id);

    FoodResponseDto update(FoodRequestDto foodRequestDto);

    List<FoodResponseDto> listFood();

    String foodOn();

    String foodOff();
}
