package digifarmfoodservice.mappers;

import digifarmfoodservice.dto.FoodRequestDto;
import digifarmfoodservice.dto.FoodResponseDto;
import digifarmfoodservice.entities.Food;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    FoodResponseDto foodToFoodResponseDTO (Food food);
    Food foodRequestDtoToFood(FoodRequestDto foodRequestDto);
}
