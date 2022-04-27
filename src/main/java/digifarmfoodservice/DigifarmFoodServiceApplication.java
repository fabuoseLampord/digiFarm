package digifarmfoodservice;

import digifarmfoodservice.dto.FoodRequestDto;
import digifarmfoodservice.dto.FoodResponseDto;
import digifarmfoodservice.services.FoodService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class DigifarmFoodServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigifarmFoodServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(FoodService foodService) {
        return args -> {
            FoodResponseDto save = foodService.save(new FoodRequestDto("C01", "PROVANDE", "Aliment complet demarrage"));

        };
    }
}
