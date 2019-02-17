package bin.Impls;

import bin.Interfaces.CarFactoryInterface;
import bin.Interfaces.CarInterface;
import bin.Models.Car;
import bin.Models.CarFactory;
import bin.Repositories.CarFactoryRepository;
import bin.Repositories.CarRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("carFactoryImpl")
public class CarFactoryImpl implements CarFactoryInterface {

    @Resource
    private CarFactoryRepository carFactoryRepository;

    public CarFactoryImpl() {
        System.out.println("create " + getClass().getSimpleName());
    }

    @Override
    public List<CarFactory> getCarFactoryById(int id) {
        return carFactoryRepository.getCarFactoryById(id);
    }
}
