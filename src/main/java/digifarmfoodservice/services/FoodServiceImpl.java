package digifarmfoodservice.services;

import digifarmfoodservice.dto.FoodRequestDto;
import digifarmfoodservice.dto.FoodResponseDto;
import digifarmfoodservice.entities.Food;
import digifarmfoodservice.entities.User;
import digifarmfoodservice.mappers.FoodMapper;
import digifarmfoodservice.repositories.FoodRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class FoodServiceImpl implements FoodService
{

    private FoodRepository foodRepository;
    private FoodMapper foodMapper;
    private RestTemplate restTemplate;

    @Value("arduino.food.path")
    private String arduinoFoodPath;


    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository, FoodMapper foodMapper)
    {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
        this.restTemplate = new RestTemplate();
    }


    @Override
    public FoodResponseDto save(FoodRequestDto foodRequestDto)
    {
        Food food = foodMapper.foodRequestDtoToFood(foodRequestDto);
        Food saveFood = foodRepository.save(food);
        FoodResponseDto foodResponseDto = foodMapper.foodToFoodResponseDTO(saveFood);
        return foodResponseDto;
    }


    @Override
    public FoodResponseDto getFood(Long id)
    {
        Food food = foodRepository.findById(id).get();
        return foodMapper.foodToFoodResponseDTO(food);
    }


    @Override
    public FoodResponseDto update(FoodRequestDto foodRequestDto)
    {
        Food food = foodMapper.foodRequestDtoToFood(foodRequestDto);
        Food updateFood = foodRepository.save(food);
        FoodResponseDto foodResponseDto = foodMapper.foodToFoodResponseDTO(updateFood);
        return foodResponseDto;
    }


    @Override
    public List<FoodResponseDto> listFood()
    {
        List<Food> foods = foodRepository.findAll();
        List<FoodResponseDto> foodResponseDtos = foods.stream()
            .map(food -> foodMapper.foodToFoodResponseDTO(food))
            .collect(Collectors.toList());
        return foodResponseDtos;
    }

    public String foodOn(User user) { return invokeFoodService(user, "on"); }


    public String foodOff(User user)
    {
        return invokeFoodService(user, "off");
    }


    private String invokeFoodService(User user, String status)
    {
        String url = "http:://" + user.getArduinoHost() + ":" + user.getArduinoPort() + "/" + arduinoFoodPath + "/" + status;
        String result = restTemplate.postForObject(url, null, String.class);
        return result;
    }
}
