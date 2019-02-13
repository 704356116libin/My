package bin.Impls;

import bin.Interfaces.CarInterface;
import bin.Interfaces.ClassifyInterface;
import bin.Models.Car;
import bin.Models.Classify;
import bin.Repositories.CarRepository;
import bin.Repositories.ClassifyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("classifyImpl")
public class ClassifyImpl implements ClassifyInterface {

    @Resource
    private ClassifyRepository classifyRepository;

    public ClassifyImpl() {
        System.out.println("create " + getClass().getSimpleName());
    }


    @Override
    public List<Classify> getClassifyById(int id) {
        return classifyRepository.getClassifyById(id);
    }
}
