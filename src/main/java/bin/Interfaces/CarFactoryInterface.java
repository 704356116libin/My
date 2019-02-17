package bin.Interfaces;

import bin.Models.Car;
import bin.Models.CarFactory;

import java.util.List;

public interface CarFactoryInterface {
    public List<CarFactory> getCarFactoryById(int id);//查询汽车厂商信息
}
