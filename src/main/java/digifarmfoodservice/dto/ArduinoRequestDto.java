package digifarmfoodservice.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArduinoRequestDto {
    private Long id;
    private String name;
    private String location;
    private String ip_dress;
    private String port_number;
}
