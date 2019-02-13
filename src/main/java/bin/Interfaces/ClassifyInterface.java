package bin.Interfaces;

import bin.Models.Car;
import bin.Models.Classify;

import java.util.List;

public interface ClassifyInterface {
    public List<Classify> getClassifyById(int id);//查询类型信息
}
