package hiber.service;

import hiber.dao.CarDAO;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private CarDAO carDAO;

    @Autowired
    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDAO.add(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return carDAO.listCars();
    }
}
