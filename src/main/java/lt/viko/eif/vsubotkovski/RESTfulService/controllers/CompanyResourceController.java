package lt.viko.eif.vsubotkovski.RESTfulService.controllers;

import lt.viko.eif.vsubotkovski.RESTfulService.models.Car;
import lt.viko.eif.vsubotkovski.RESTfulService.models.Company;
import lt.viko.eif.vsubotkovski.RESTfulService.repo.CompanyRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Main controller which controls Company resources.
 *
 */
@RestController
@RequestMapping(value = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyResourceController {
    private CompanyRepository companyRepository = new CompanyRepository();

    /**
     * Method which gets Company class from XML file and returns it as Response entity.
     *
     * @return Response entity of entity model of Company class.
     */
    @GetMapping
    public ResponseEntity<EntityModel<Company>> getCompany() {

        EntityModel<Company> company = EntityModel.of(companyRepository.getCompany());
        final String selfString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        company.add(Link.of(selfString, "self"));
        company.add(linkTo(methodOn(CompanyResourceController.class).getCars()).withRel("get-all-cars"));

        return ResponseEntity.ok(company);
    }

    /**
     *  Method which gets List of cars from XML file and returns it as Collection Model.
     *
     * @return Collection model of entity model of Car class.
     */
    @GetMapping("/cars")
    @ResponseBody
    public CollectionModel<EntityModel<Car>> getCars() {

        List<EntityModel<Car>> cars = companyRepository.getVehicles().stream().map(
                car -> EntityModel.of(car,
                        linkTo(methodOn(CompanyResourceController.class).getCarById(car.getId())).withSelfRel(),
                        linkTo(methodOn(CompanyResourceController.class).getCars()).withRel("get-all-cars"))).collect(Collectors.toList());
        return CollectionModel.of(cars, linkTo(methodOn(CompanyResourceController.class).getCars()).withSelfRel());
    }

    /**
     *  Method which gets car by id from XML file and returns it as Response entity.
     *
     * @param id Represents car id.
     * @return Response entity of entity model of Car class.
     */
    @GetMapping("/cars/{id}")
    @ResponseBody
    public ResponseEntity<EntityModel<Car>> getCarById(@PathVariable(value="id", required = false) Integer id) {

        EntityModel<Car> car = EntityModel.of(companyRepository.getCarById(id));
        final String selfString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        car.add(Link.of(selfString, "self"));
        car.add(linkTo(methodOn(CompanyResourceController.class).getCars()).withRel("get-all-cars"));
        return ResponseEntity.ok(car);
    }

    /**
     * Method which puts new car to the XML file.
     *
     * @param newCar Car model to be added to XML file.
     * @return Response entity string.
     */
    @PostMapping("/cars")
    public ResponseEntity<String> newEmployee(@RequestBody Car newCar) {

        try {
            companyRepository.addCar(newCar);
            return new ResponseEntity<>("resource created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Method which updates old car with new one in XML file, id stays the same.
     *
     * @param newCar New car model to update existing one.
     * @param id Existing car to update id.
     * @return Response entity string.
     */
    @PutMapping("/cars/{id}")
    public ResponseEntity<String> replaceEmployee(@RequestBody Car newCar, @PathVariable(value="id") Integer id) {

        try {
            companyRepository.updateCar(newCar, id);
            return new ResponseEntity<>("Car successfully updated!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Method which removes a car from XML file, id stays the same.
     *
     * @param id Car to delete id.
     * @return Response entity string.
     */
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value="id") Integer id) {

        try {
            companyRepository.removeCar(id);
            return new ResponseEntity<>("Car successfully removed!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

}
