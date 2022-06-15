package digifarmfoodservice.services;

import digifarmfoodservice.dto.ArduinoRequestDto;
import digifarmfoodservice.dto.ArduinoResponseDto;
import digifarmfoodservice.entities.Arduino;
import digifarmfoodservice.mappers.ArduinoMapper;
import digifarmfoodservice.repositories.ArduinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ArduinoServiceImpl implements ArduinoService{
    private ArduinoRepository arduinoRepository;
    private ArduinoMapper arduinoMapper;
    private RestTemplate restTemplate;

   /* @Value("arduino.food.path")
    private String arduinoFoodPath;*/


    @Autowired
    public ArduinoServiceImpl(ArduinoRepository arduinoRepository, ArduinoMapper arduinoMapper)
    {
        this.arduinoRepository = arduinoRepository;
        this.arduinoMapper = arduinoMapper;
        this.restTemplate = new RestTemplate();
    }


    @Override
    public ArduinoResponseDto save(ArduinoRequestDto arduinoRequestDto)
    {
        Arduino arduino= arduinoMapper.arduinoRequestDtoToArduino(arduinoRequestDto);
        Arduino saveArduino = arduinoRepository.save(arduino);
        ArduinoResponseDto arduinoResponseDto = arduinoMapper.arduinoToArduinoResponseDTO(saveArduino);
        return arduinoResponseDto;
    }


    @Override
    public ArduinoResponseDto getArduino(Long id)
    {
       Arduino arduino = arduinoRepository.findById(id).get();
        return arduinoMapper.arduinoToArduinoResponseDTO(arduino);
    }


    @Override
    public ArduinoResponseDto update(ArduinoRequestDto arduinoRequestDto)
    {
        Arduino arduino = arduinoMapper.arduinoRequestDtoToArduino(arduinoRequestDto);
        Arduino updateArduino = arduinoRepository.save(arduino);
        ArduinoResponseDto arduinoResponseDto = arduinoMapper.arduinoToArduinoResponseDTO(updateArduino);
        return arduinoResponseDto;
    }



    @Override
    public List<ArduinoResponseDto> listArduino()
    {
        List<Arduino> arduinos = arduinoRepository.findAll();
        List<ArduinoResponseDto> arduinoResponseDtos = arduinos.stream()
                .map(arduino -> arduinoMapper.arduinoToArduinoResponseDTO(arduino))
                .collect(Collectors.toList());
        return arduinoResponseDtos;
    }




/*
    private String invokeArduinoService(User user, String status)
    {
        String url = "http:://" + user.getArduinoHost() + ":" + user.getArduinoPort() + "/" + arduinoFoodPath + "/" + status;
        String result = restTemplate.postForObject(url, null, String.class);
        return result;
    }*/
}
