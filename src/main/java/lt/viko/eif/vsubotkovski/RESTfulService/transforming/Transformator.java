/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.viko.eif.vsubotkovski.RESTfulService.transforming;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import lt.viko.eif.vsubotkovski.RESTfulService.models.Company;

/**
 * JAXB transformation form object to XML and vice versa logic implementation.
 *
 * @author valde
 */
public class Transformator {

    /**
     * Method dedicated to transform Company Object to XML by company object.
     *
     * @param company - object to transform to the XML file.
     * @param newFileName
     * @throws javax.xml.bind.PropertyException
     * @throws java.io.FileNotFoundException
     */
    public void transformToXml(Company company, String newFileName) throws JAXBException, FileNotFoundException {
        // JAXB transformation to XML logic
        JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(company, new FileOutputStream(newFileName));
    }

    /**
     * Method dedicated to transform XML document to Object by given path
     * string.
     *
     * @param fileName - XML document file name.
     * @return new Company object created from XML document
     * @throws javax.xml.bind.JAXBException
     * @throws java.io.IOException
     */
    public Company transformToObject(String fileName) throws JAXBException, IOException {
        // JAXB transformation to POJO logic
        JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Path path = Path.of(fileName);
        String actual = Files.readString(path);
        StringReader reader = new StringReader(actual);
        Company company = (Company) unmarshaller.unmarshal(reader);
        return company;
    }
}
