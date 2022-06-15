package digifarmfoodservice.mappers;

import digifarmfoodservice.dto.ArduinoRequestDto;
import digifarmfoodservice.dto.ArduinoResponseDto;
import digifarmfoodservice.entities.Arduino;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArduinoMapper {
    ArduinoResponseDto arduinoToArduinoResponseDTO (Arduino arduino);
    Arduino arduinoRequestDtoToArduino(ArduinoRequestDto arduinoRequestDto);
}
