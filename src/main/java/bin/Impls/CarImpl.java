package bin.Impls;

import bin.Interfaces.CarInterface;
import bin.Interfaces.UserInterface;
import bin.Models.Car;
import bin.Models.User;
import bin.Repositories.CarRepository;
import bin.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("carImpl")
public class CarImpl implements CarInterface {

    @Resource
    private CarRepository carRepository;

    public CarImpl() {
        System.out.println("create " + getClass().getSimpleName());
    }

    @Override
    public List<Car> getCarById(int id) {
        return carRepository.getCarById(id);
    }
}
