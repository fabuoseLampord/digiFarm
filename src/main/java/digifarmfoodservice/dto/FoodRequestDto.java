package digifarmfoodservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodRequestDto {
    private String id;
    private String name;
    private String description;
    //private Date date;
}
