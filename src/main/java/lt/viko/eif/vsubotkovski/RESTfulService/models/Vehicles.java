package lt.viko.eif.vsubotkovski.RESTfulService.models;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Class Vehicles which consist of cars List.
 *
 * @author valde
 */
public class Vehicles {

    private List<Car> cars;

    /**
     * Method to get cars List.
     *
     * @return
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * Method to set cars List.
     *
     * @param cars
     */
    @XmlElement(name = "car")
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * Method to return Vehicles class in string format.
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Vehicles:\nCars:\n%s", cars);
    }
}
