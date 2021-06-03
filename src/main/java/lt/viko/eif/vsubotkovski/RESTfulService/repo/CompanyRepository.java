package lt.viko.eif.vsubotkovski.RESTfulService.repo;

import lt.viko.eif.vsubotkovski.RESTfulService.models.Car;
import lt.viko.eif.vsubotkovski.RESTfulService.models.Company;
import lt.viko.eif.vsubotkovski.RESTfulService.models.Vehicles;
import lt.viko.eif.vsubotkovski.RESTfulService.transforming.Transformator;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

/**
 * Class which controls Company XML file.
 *
 */
public class CompanyRepository {
    private static Transformator transformator = new Transformator();

    /**
     * Method which gets and return Company from XML file.
     *
     * @return Company object.
     */
    public Company getCompany() {
        try {
            return transformator.transformToObject("company.xml");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method which gets and returns list of cars from XML file.
     *
     * @return List of Car objects.
     */
    public List<Car> getVehicles() {
        try {
            return transformator.transformToObject("company.xml").getVehicles().getCars();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  Method which gets and returns car by car's id from XML file.
     *
     * @param id Car's id.
     * @return Car object.
     */
    public Car getCarById(Integer id) {
        for (Car car : getVehicles())
            if (car.getId().equals(id))
                return car;
        return null;
    }

    /**
     * Method which adds new car to XML file, new car should have exclusive id.
     *
     * @param newCar Car object to be added to XML file.
     * @throws Exception If new car's id is repeated in other cars.
     */
    public void addCar(Car newCar) throws Exception {
        Company company = getCompany();
        Vehicles vehicles = company.getVehicles();
        List<Car> cars = vehicles.getCars();
        for (Car temp: cars) {
            if(temp.getId() == newCar.getId())
            {
                throw new Exception("Car with this id already exists!");
            }
        }
        cars.add(newCar);
        vehicles.setCars(cars);
        company.setVehicles(vehicles);
        transformator.transformToXml(company, "company.xml");
    }

    /**
     * Method which removes a car by id from XML file.
     *
     * @param id Car's to remove id.
     * @throws Exception If car with given id is not found.
     */
    public void removeCar(Integer id) throws Exception {
        Company company = getCompany();
        Vehicles vehicles = company.getVehicles();
        List<Car> cars = vehicles.getCars();
        for (Car temp: cars) {
            if(temp.getId() == id)
            {
                cars.remove(temp);
                vehicles.setCars(cars);
                company.setVehicles(vehicles);
                transformator.transformToXml(company, "company.xml");
                return;
            }
        }
        throw new Exception("Car not found!");
    }

    /**
     * Method which updates existing car by id, in XML file.
     *
     * @param newCar Car to update object.
     * @param id Car to be updated to id.
     * @throws Exception If car with id is not found.
     */
    public void updateCar(Car newCar, Integer id) throws Exception {
        Company company = getCompany();
        Vehicles vehicles = company.getVehicles();
        List<Car> cars = vehicles.getCars();
        for (Car temp: cars) {
            if(temp.getId() == id)
            {
                cars.remove(temp);
                newCar.setId(id);
                cars.add(newCar);
                vehicles.setCars(cars);
                company.setVehicles(vehicles);
                transformator.transformToXml(company, "company.xml");
                return;
            }
        }
        throw new Exception("Car not found!");
    }
}
