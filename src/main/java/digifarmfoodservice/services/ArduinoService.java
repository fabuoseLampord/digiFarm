package digifarmfoodservice.services;

import digifarmfoodservice.dto.ArduinoRequestDto;
import digifarmfoodservice.dto.ArduinoResponseDto;

import java.util.List;

public interface ArduinoService {
    ArduinoResponseDto save(ArduinoRequestDto arduinoRequestDto);
    ArduinoResponseDto getArduino(Long id);
   ArduinoResponseDto update(ArduinoRequestDto arduinoRequestDto);

    List<ArduinoResponseDto> listArduino();
}
