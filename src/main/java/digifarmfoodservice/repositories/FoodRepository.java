package digifarmfoodservice.repositories;

import digifarmfoodservice.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long>
{
}
