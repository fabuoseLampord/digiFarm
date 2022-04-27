package digifarmfoodservice.web;

import digifarmfoodservice.dto.FoodRequestDto;
import digifarmfoodservice.dto.FoodResponseDto;
import digifarmfoodservice.services.FoodService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController
{
    private FoodService foodService;


    public FoodController(FoodService foodService)
    {
        this.foodService = foodService;
    }


    @GetMapping
    public List<FoodResponseDto> allFoods()
    {
        return foodService.listFood();
    }


    @PostMapping
    public FoodResponseDto save(FoodRequestDto foodRequestDto)
    {
        return foodService.save(foodRequestDto);

    }


    @GetMapping("/{id}")
    public FoodResponseDto getFood(@PathVariable String id)
    {
        return foodService.getFood(id);
    }


    @PostMapping("/on")
    public String foodOn()
    {
        return foodService.foodOn();
    }


    @PostMapping("/off")
    public String foodOff()
    {
        return foodService.foodOff();
    }
}
