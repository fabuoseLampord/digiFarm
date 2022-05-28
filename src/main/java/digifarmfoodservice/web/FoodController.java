package digifarmfoodservice.web;

import digifarmfoodservice.dto.FoodRequestDto;
import digifarmfoodservice.dto.FoodResponseDto;
import digifarmfoodservice.entities.User;
import digifarmfoodservice.services.FoodService;
import digifarmfoodservice.services.UserDetailsServiceImpl;
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
    private UserDetailsServiceImpl userService;


    public FoodController(FoodService foodService, UserDetailsServiceImpl userService)
    {
        this.foodService = foodService;
        this.userService = userService;
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
    public FoodResponseDto getFood(@PathVariable Long id)
    {
        return foodService.getFood(id);
    }


    @PostMapping("/on")
    public String foodOn()
    {
        User user = userService.getCurrentUser();
        return foodService.foodOn(user);
    }


    @PostMapping("/off")
    public String foodOff()
    {
        User user = userService.getCurrentUser();
        return foodService.foodOff(user);
    }
}
