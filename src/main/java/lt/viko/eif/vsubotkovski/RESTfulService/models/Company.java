/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.viko.eif.vsubotkovski.RESTfulService.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class which represents company and consists of companyName, adress, city,
 * urlAdress, tel and vehicles class.
 *
 * @author valde
 */
@XmlRootElement
public class Company {

    private String companyName;
    private String adress;
    private String city;
    private String urlAdress;
    private String tel;
    private Vehicles vehicles;

    /**
     * Method to get companyName.
     *
     * @return
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Method to set companyName.
     *
     * @param companyName - represents company name.
     */
    @XmlElement(name = "company-name")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Method to get adress.
     *
     * @return
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Method to set adress.
     *
     * @param adress - represents adress.
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Method to get city.
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * Method to set city.
     *
     * @param city - represents city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method to get urlAdress.
     *
     * @return
     */
    public String getUrlAdress() {
        return urlAdress;
    }

    /**
     * Method to set url adress.
     *
     * @param urlAdress - represents url adress.
     */
    @XmlElement(name = "url-adress")
    public void setUrlAdress(String urlAdress) {
        this.urlAdress = urlAdress;
    }

    /**
     * Method to get tel.
     *
     * @return
     */
    public String getTel() {
        return tel;
    }

    /**
     * Method to set tel.
     *
     * @param tel - represents tel.
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Method to get Vehicles.
     *
     * @return
     */
    public Vehicles getVehicles() {
        return vehicles;
    }

    /**
     * Method to set vehicles.
     *
     * @param vehicles - represents vehicles.
     */
    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Method which returns Company class in string format.
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("\nCompany:\ncompanyName = %s\nadress = %s\ncity = %s\nurl_adress = %s\ntel = %s\n%s", companyName, adress, city, urlAdress, tel, vehicles);
    }
}
