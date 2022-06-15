package digifarmfoodservice.web;

import digifarmfoodservice.dto.ArduinoRequestDto;
import digifarmfoodservice.dto.ArduinoResponseDto;
import digifarmfoodservice.services.ArduinoService;
import digifarmfoodservice.services.UserDetailsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arduino")
public class ArduinoController {
    private ArduinoService arduinoService;
    private UserDetailsServiceImpl userService;


    public ArduinoController(ArduinoService arduinoService, UserDetailsServiceImpl userService)
    {
        this.arduinoService = arduinoService;
        this.userService = userService;
    }


    @GetMapping
    public List<ArduinoResponseDto> allArduinos()
    {
        return arduinoService.listArduino();
    }


    @PostMapping
    public ArduinoResponseDto save(ArduinoRequestDto arduinoRequestDto)
    {
        return arduinoService.save(arduinoRequestDto);

    }


    @GetMapping("/{id}")
    public ArduinoResponseDto getArduino(@PathVariable Long id)
    {
        return arduinoService.getArduino(id);
    }

/*
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
    }*/
}
